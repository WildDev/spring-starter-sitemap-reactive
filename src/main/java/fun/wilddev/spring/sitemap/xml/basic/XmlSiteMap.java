package fun.wilddev.spring.sitemap.xml.basic;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import lombok.*;

/**
 * {@code <urlset>} schema
 */
@JacksonXmlRootElement(localName = "urlset")
@AllArgsConstructor
@Setter
@Getter
@ToString
public class XmlSiteMap {

    /**
     * Default namespace
     */
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns")
    private final String defaultNs = "http://www.sitemaps.org/schemas/sitemap/0.9";

    /**
     * {@code <url>} entries list
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<XmlSiteMapEntry> url;
}
