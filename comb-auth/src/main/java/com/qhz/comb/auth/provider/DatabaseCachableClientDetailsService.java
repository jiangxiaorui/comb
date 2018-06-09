package com.qhz.comb.auth.provider;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qhz.comb.auth.model.domain.SysOauthClient;
import com.qhz.comb.auth.service.SysOauthClientService;
import com.qhz.comb.framework.core.constant.GlobalConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 基于数据库可缓存的客户端服务
 *
 * @author jiangting
 * @since 1.0, 2018/5/23
 */
@Service
public class DatabaseCachableClientDetailsService implements ClientDetailsService, ClientRegistrationService {

    private static final String OAUTH_CLINET_DETAILS_CACHE = GlobalConstant.ROOT_PREFIX + "oauth_client_details";

    @Autowired
    private SysOauthClientService sysOauthClientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Cacheable(value = OAUTH_CLINET_DETAILS_CACHE, key = "#clientId")
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<SysOauthClient> clientOptional = Optional.of(this.sysOauthClientService.findOneByColumn("client_id", clientId));
        return clientOptional.map(entityToDomain).<ClientRegistrationException>orElseThrow(() -> new NoSuchClientException("Client ID not found"));
    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        this.addClientDetailsWithCache(clientDetails);
    }

    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = OAUTH_CLINET_DETAILS_CACHE, key = "#clientDetails.clientId")
    public ClientDetails addClientDetailsWithCache(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        if (this.sysOauthClientService.findOneByColumn("client_id", clientDetails.getClientId()) != null) {
            throw new ClientAlreadyExistsException("Client ID already exists");
        }

        SysOauthClient client = SysOauthClient.builder()
                .clientId(clientDetails.getClientId())
                .clientSecret(clientDetails.getClientSecret())
                .accessTokenValidity(clientDetails.getAccessTokenValiditySeconds())
                .refreshTokenValidity(clientDetails.getRefreshTokenValiditySeconds()).build();

        client.setAuthorizedGrantTypes(clientDetails.getAuthorizedGrantTypes().stream().collect(Collectors.joining(",")));
        client.setRedirectUri(clientDetails.getRegisteredRedirectUri().stream().collect(Collectors.joining(",")));
        client.setScopes(clientDetails.getScope().stream().collect(Collectors.joining(",")));
        this.sysOauthClientService.insert(client);

        return clientDetails;
    }

    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = OAUTH_CLINET_DETAILS_CACHE, key = "#clientDetails.clientId")
    public ClientDetails updateCachedClientDetail(ClientDetails clientDetails) throws NoSuchClientException {
        Optional<SysOauthClient> clientOptional = Optional.of(this.sysOauthClientService.findOneByColumn("client_id", clientDetails.getClientId()));
        return clientOptional.map(entityToDomain).<ClientRegistrationException>orElseThrow(() -> new NoSuchClientException("Client ID not found"));
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
        this.updateCachedClientDetail(clientDetails);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        Optional<SysOauthClient> clientOptional = Optional.of(this.sysOauthClientService.findOneByColumn("client_id", clientId));
        clientOptional.orElseThrow(() -> new NoSuchClientException("Client ID not found"));
        clientOptional.get().setClientSecret(passwordEncoder.encode(secret));
        this.sysOauthClientService.updateById(clientOptional.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = OAUTH_CLINET_DETAILS_CACHE, key = "#clientId")
    public void removeClientDetails(String clientId) throws NoSuchClientException {
        EntityWrapper<SysOauthClient> wrapper = new EntityWrapper<>();
        wrapper.eq("client_id", clientId);
        this.sysOauthClientService.delete(wrapper);
    }

    @Override
    public List<ClientDetails> listClientDetails() {
        return this.sysOauthClientService.selectAll().stream().filter(SysOauthClient::getEnable).map(entityToDomain).collect(Collectors.toList());
    }

    private final Function<? super SysOauthClient, ? extends BaseClientDetails> entityToDomain = entity -> {
        BaseClientDetails clientDetails = new BaseClientDetails();

        clientDetails.setClientId(entity.getClientId());
        clientDetails.setClientSecret(entity.getClientSecret());

        clientDetails.setAccessTokenValiditySeconds(entity.getAccessTokenValidity());
        clientDetails.setRefreshTokenValiditySeconds(entity.getRefreshTokenValidity());

        clientDetails.setAuthorizedGrantTypes(Arrays.asList(StringUtils.split(entity.getAuthorizedGrantTypes(), ",")));

        clientDetails.setScope(Arrays.asList(StringUtils.split(entity.getScopes(), ",")));

        clientDetails.setAutoApproveScopes(Arrays.asList(StringUtils.split(entity.getAutoApproves(), ",")));

        if (StringUtils.isNotEmpty(entity.getResourceIds())) {
            clientDetails.setResourceIds(Arrays.stream(StringUtils.split(entity.getResourceIds(), ",")).collect(Collectors.toList()));
        }

        if (StringUtils.isNotEmpty(entity.getRedirectUri())) {
            clientDetails.setRegisteredRedirectUri(Arrays.stream(StringUtils.split(entity.getRedirectUri(), ",")).collect(Collectors.toSet()));
        }

        if(StringUtils.isNotEmpty(entity.getAdditionalInformation())){
            clientDetails.setAdditionalInformation(Collections.<String, Object>emptyMap());
        }
        return clientDetails;
    };
}
