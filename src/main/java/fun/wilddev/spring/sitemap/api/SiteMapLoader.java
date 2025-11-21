package fun.wilddev.spring.sitemap.api;

import reactor.core.publisher.Flux;

/**
 * Defines how sitemap data should be loaded
 */
public interface SiteMapLoader {

    /**
     * Loads sitemap data
     *
     * @return sitemap entries list
     */
    Flux<SiteMapEntry> load();
}
