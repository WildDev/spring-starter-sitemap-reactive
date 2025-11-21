package fun.wilddev.spring.sitemap.xml.basic.mappers;

import fun.wilddev.spring.sitemap.xml.basic.XmlSiteMapEntry;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import fun.wilddev.spring.sitemap.api.*;
import org.mapstruct.*;

/**
 * {@link XmlSiteMapEntry} instances mapper
 */
@Slf4j
@Mapper(componentModel = "spring")
public abstract class XmlDynamicSiteMapEntryMapper {

    /**
     * {@link XmlSiteMapEntry} mapper
     */
    @Autowired
    private XmlSiteMapEntryMapper xmlSiteMapEntryMapper;

    /**
     * Maps different {@link XmlSiteMapEntry} implementations based on type of {@link SiteMapEntry}
     *
     * @param source - source entry
     * @return {@link XmlSiteMapEntry} instance
     */
    public XmlSiteMapEntry map(SiteMapEntry source) {

        if (source == null)
            return null;

        final Class<?> type = source.getClass();

        if (type == SiteMapEntry.class)
            return xmlSiteMapEntryMapper.map(source);

        log.warn("Unknown element type '{}'", type);

        return null;
    }
}
