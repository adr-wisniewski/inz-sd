package sd.im.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import sd.im.app.Comment;
import sd.im.app.CommentDao;

@Repository
public class InMemoryCommentDao implements CommentDao {
	private static Logger logger = Logger.getLogger(InMemoryCommentDao.class);
	
	private List<Comment> comments;
	
	//private static int COMMENT_ID_SEQ = 1;
	
	public InMemoryCommentDao() {
		this.comments = new LinkedList<Comment>();
	}
	
	public List<Comment> getCommentByRequestId(Integer requestId) {
		List<Comment> result = new LinkedList<Comment>();
		
		for(Comment c : comments) {
			if(c.getRequestId().equals(requestId)) {
				result.add(c);
			}
		}
		
		return result;
	}

	public void save(Comment comment) {
		logger.info("InMemoryCommentDao.save(): " + comment);
		
		if(!comments.contains(comment)) {
			comment.setCreationDate(new Date());
			comments.add(comment);
			
			logger.info("!comments.contains: " + comment);
		}
		
		logger.info("comments: " + comments);
	}

}
