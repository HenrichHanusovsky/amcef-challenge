package com.hanusovsky.amcef.app;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanusovsky.amcef.app.entity.Post;
import com.hanusovsky.amcef.external.dto.ExternalPost;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    /**
     * Model mapper used inside application
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Strict strategy so only fields that names are exactly matching are mapped
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // When mapping external post from API to our post, we don't want to keep the ID,
        // therefore we create separate mapping
        TypeMap<ExternalPost, Post> propertyMapper = modelMapper.createTypeMap(ExternalPost.class, Post.class);
        propertyMapper.addMappings(mapper -> mapper.skip(Post::setId));

        return modelMapper;
    }


    /**
     * Object mapper used inside application
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // We want Object mapper to fail when we provide body, which contains non-specified (unknown) fields
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        return objectMapper;
    }
}
