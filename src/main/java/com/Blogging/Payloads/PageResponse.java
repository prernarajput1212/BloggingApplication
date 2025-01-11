package com.Blogging.Payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class PageResponse {
	private List<PostDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElement;
	private Boolean lastPage;

}
