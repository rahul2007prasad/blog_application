package com.app.service;

import com.app.payload.CommentDto;

public interface ICommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);

}
