package fun.wilddev.spring.sitemap.xml.basic.mappers;

import fun.wilddev.spring.sitemap.api.SiteMapEntry;
import fun.wilddev.spring.sitemap.xml.basic.XmlSiteMapEntry;

import org.mapstruct.*;

/**
 * {@link XmlSiteMapEntry} mapper
 */
@Mapper(componentModel = "spring")
public interface XmlSiteMapEntryMapper {

    /**
     * Maps {@link XmlSiteMapEntry} based on {@link SiteMapEntry}
     *
     * @param source - source instance
     * @return {@link XmlSiteMapEntry} instance
     */
    @Mapping(target = "loc", source = "url")
    XmlSiteMapEntry map(SiteMapEntry source);
}
