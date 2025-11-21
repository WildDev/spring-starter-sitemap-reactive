package fun.wilddev.spring.sitemap.controllers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import fun.wilddev.spring.sitemap.conf.Mappers;
import fun.wilddev.spring.sitemap.xml.basic.XmlSiteMap;
import fun.wilddev.spring.sitemap.xml.basic.mappers.XmlDynamicSiteMapEntryMapper;
import fun.wilddev.spring.web.controllers.AbstractReactiveController;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

import fun.wilddev.spring.sitemap.api.*;
import org.springframework.web.bind.annotation.*;

/**
 * Sitemap endpoint controller
 */
@ConditionalOnProperty(name = "sitemap.endpoint.enabled", matchIfMissing = true)
@RequestMapping("/sitemap")
@RestController
public class SiteMapController extends AbstractReactiveController {

    /**
     * Server response mapper
     */
    private final XmlMapper xmlMapper;

    /**
     * Sitemap entries mapper
     */
    private final XmlDynamicSiteMapEntryMapper xmlDynamicSiteMapEntryMapper;

    /**
     * {@link SiteMapLoader} reference
     */
    private final SiteMapLoader siteMapLoader;

    /**
     * All-args constructor
     *
     * @param xmlMapper - server response mapper
     * @param xmlDynamicSiteMapEntryMapper - sitemap entries mapper
     * @param siteMapLoader - {@link SiteMapLoader} reference
     */
    public SiteMapController(@Qualifier(Mappers.XML_MAPPER) XmlMapper xmlMapper,
                             XmlDynamicSiteMapEntryMapper xmlDynamicSiteMapEntryMapper,
                             SiteMapLoader siteMapLoader) {

        this.xmlMapper = xmlMapper;
        this.xmlDynamicSiteMapEntryMapper = xmlDynamicSiteMapEntryMapper;
        this.siteMapLoader = siteMapLoader;
    }

    /**
     * Exposes xml sitemap
     *
     * @return xml sitemap
     */
    @GetMapping(value = "/xml", produces = "application/xml")
    public Mono<ResponseEntity<Object>> getSiteMapXml() {

        return siteMapLoader.load()
                .map(xmlDynamicSiteMapEntryMapper::map).collectList().map(XmlSiteMap::new)
                .flatMap(i -> Mono.fromCallable(() -> xmlMapper.writeValueAsString(i)))
                .flatMap(this::ok);
    }
}
