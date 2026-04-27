package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.turkcell.spring_starter.dto.tag.CreateTagRequest;
import com.turkcell.spring_starter.dto.tag.CreatedTagResponse;
import com.turkcell.spring_starter.dto.tag.GetByIdTagResponse;
import com.turkcell.spring_starter.dto.tag.ListTagResponse;
import com.turkcell.spring_starter.dto.tag.UpdateTagRequest;
import com.turkcell.spring_starter.dto.tag.UpdatedTagResponse;
import com.turkcell.spring_starter.entity.Tag;
import com.turkcell.spring_starter.repository.TagRepository;

@Service
public class TagServiceImpl {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public CreatedTagResponse create(CreateTagRequest request) {
        Tag tag = new Tag();
        tag.setName(request.getName());

        this.tagRepository.save(tag);

        CreatedTagResponse response = new CreatedTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());

        return response;
    }

    public List<ListTagResponse> getAll() {
        return this.tagRepository.findAll().stream().map(tag -> {
            ListTagResponse response = new ListTagResponse();
            response.setId(tag.getId());
            response.setName(tag.getName());
            return response;
        }).toList();
    }

    public GetByIdTagResponse getById(UUID id) {
        Tag tag = this.tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag bulunamadı: " + id));

        GetByIdTagResponse response = new GetByIdTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());
        response.setProductNames(tag.getProducts().stream()
                .map(product -> product.getName())
                .collect(Collectors.toSet()));

        return response;
    }

        public UpdatedTagResponse update(UUID id, UpdateTagRequest request) {
        Tag tag = this.tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag bulunamadı: " + id));
        tag.setName(request.getName());

        this.tagRepository.save(tag);

        UpdatedTagResponse response = new UpdatedTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());

        return response;
    }

    public void delete(UUID id) {
        Tag tag = this.tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag bulunamadı: " + id));
        this.tagRepository.delete(tag);
    }
}
