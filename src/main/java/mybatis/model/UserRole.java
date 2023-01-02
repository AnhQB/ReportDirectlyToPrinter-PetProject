package mybatis.model;

public class UserRole {
	private int userId;
	private int roleId;
	
	public UserRole() {
		super();
	}

	public UserRole(int userId, int roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
