### Description

Sitemap exposure starter for reactive [Spring](https://spring.io) apps.

[![Java CI with Maven](https://github.com/WildDev/spring-starter-sitemap-reactive/actions/workflows/maven.yml/badge.svg)](https://github.com/WildDev/spring-starter-sitemap-reactive/actions/workflows/maven.yml)

### How to use

1. Implement `fun.wilddev.spring.sitemap.api.SiteMapLoader`:

```java
@Component
public class ExampleSiteMapLoader implements SiteMapLoader {

    @Override
    public List<SiteMapEntry> load() {
        return List.of(
                new SiteMapEntry("https://test.website/test_1", LocalDateTime.now()),
                new SiteMapEntry("https://test.website/test_2", LocalDateTime.now()),
                new SiteMapEntry("https://test.website/test_3", LocalDateTime.now())
        );
    }
}
```

2. Access the sitemap endpoint by `https://test.website/sitemap/xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
    <url>
        <loc>https://test.website/test_1</loc>
        <lastmod>2024-11-03T18:24:19Z</lastmod>
    </url>
    <url>
        <loc>https://test.website/test_2</loc>
        <lastmod>2024-11-03T17:11:16Z</lastmod>
    </url>
    <url>
        <loc>https://test.website/test_3</loc>
        <lastmod>2024-11-03T17:54:17Z</lastmod>
    </url>
</urlset>
```

### Get started

Build requirements:
* JDK v16-23 and Maven v3

Also available in Maven central:

```xml
<dependency>
    <groupId>fun.wilddev.lib</groupId>
    <artifactId>spring-starter-sitemap-reactive</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### License

*This project is licensed under the Apache License 2.0.*

Dependencies:

- Spring Boot (Apache 2.0)
- FasterXML (Apache 2.0)
- MapStruct (Apache 2.0)
- Lombok (MIT)

See [LICENSE](LICENSE) and [NOTICE](NOTICE) files for details.
