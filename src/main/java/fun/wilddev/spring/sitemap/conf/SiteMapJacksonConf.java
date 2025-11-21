package fun.wilddev.spring.sitemap.conf;

import com.ctc.wstx.api.WstxOutputProperties;
import com.ctc.wstx.stax.WstxOutputFactory;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.fasterxml.jackson.dataformat.xml.*;
import org.springframework.context.annotation.*;

/**
 * Jackson configuration
 */
@Configuration
public class SiteMapJacksonConf {

    /**
     * Default constructor
     */
    public SiteMapJacksonConf() {

    }

    /**
     * Custom {@link XmlMapper} definition
     *
     * @return {@link XmlMapper} instance
     */
    @Bean(Mappers.XML_MAPPER)
    public XmlMapper xmlMapper() {

        WstxOutputFactory outputFactory = new WstxOutputFactory();
        outputFactory.setProperty(WstxOutputProperties.P_USE_DOUBLE_QUOTES_IN_XML_DECL, true);

        XmlMapper mapper = new XmlMapper(new XmlFactory(null, outputFactory));

        mapper.registerModule(new JavaTimeModule());
        mapper.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);

        return mapper;
    }
}
