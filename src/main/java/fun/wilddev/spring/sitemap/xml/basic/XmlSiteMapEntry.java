package fun.wilddev.spring.sitemap.xml.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.OffsetDateTime;

import lombok.*;

/**
 * {@code <url>} schema
 */
@Setter
@Getter
@ToString
public class XmlSiteMapEntry {

    /**
     * Sitemap {@code <loc>}
     */
    @JacksonXmlProperty
    protected String loc;

    /**
     * Sitemap {@code <lastmod>}
     */
    @JacksonXmlProperty(localName = "lastmod")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    protected OffsetDateTime lastModified;
}
