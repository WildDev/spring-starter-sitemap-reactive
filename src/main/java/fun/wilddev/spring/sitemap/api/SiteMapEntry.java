package fun.wilddev.spring.sitemap.api;

import java.time.OffsetDateTime;

import lombok.*;

/**
 * Represents {@code <url>} block from the original sitemap specification
 */
@Getter
@ToString
public class SiteMapEntry {

    /**
     * Resource url (loc)
     */
    private final String url;

    /**
     * Last modification timestamp (lastmod)
     */
    private final OffsetDateTime lastModified;

    /**
     * All-args constructor
     *
     * @param url - resource url (loc)
     * @param lastModified - last modification timestamp (lastmod)
     */
    public SiteMapEntry(String url, OffsetDateTime lastModified) {

        this.url = url;
        this.lastModified = lastModified;
    }
}
