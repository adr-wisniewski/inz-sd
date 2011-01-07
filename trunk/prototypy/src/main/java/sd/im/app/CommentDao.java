package sd.im.app;

import java.util.List;

public interface CommentDao {
	/**
	 * 
	 * @param comment
	 */
	public void save(Comment comment);
	/**
	 * 
	 * @return
	 */
	public List<Comment> getCommentByRequestId(Integer requestId);
}
