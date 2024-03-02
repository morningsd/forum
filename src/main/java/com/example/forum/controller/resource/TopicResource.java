package com.example.forum.controller.resource;

import com.example.forum.controller.dto.TopicDto;
import com.example.forum.controller.utils.ObjectMapperManager;
import com.example.forum.entity.Topic;
import com.example.forum.service.TopicService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static jakarta.ws.rs.core.Response.Status;

@Path("/topics")
public class TopicResource {

    @Inject
    private TopicService topicService;

    private final ObjectMapper mapper = ObjectMapperManager.getObjectMapper();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {
        Topic topic = topicService.findById(id);

        TopicDto topicDto = mapper.convertValue(topic, TopicDto.class);

        return Response
                .status(Status.OK)
                .entity(topicDto)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Topic> topicList = topicService.findAll();

        List<TopicDto> topicDtoList = mapper.convertValue(topicList, new TypeReference<>() {
        });

        return Response
                .status(Status.OK)
                .entity(topicDtoList)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(TopicDto topicDto) {
        Topic topic = mapper.convertValue(topicDto, Topic.class);

        Topic savedTopic = topicService.save(topic);

        TopicDto savedTopicDto = mapper.convertValue(savedTopic, TopicDto.class);

        return Response
                .status(Status.CREATED)
                .entity(savedTopicDto)
                .build();
    }

}
