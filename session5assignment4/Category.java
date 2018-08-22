package session5assignment4;

public class Category {
	String ParentType;
	int totalChilds;

	public Category(String parentType, int totalChilds) {
		super();
		ParentType = parentType;
		this.totalChilds = totalChilds;
	}

	/**
	 * @return the parentType
	 */
	public String getParentType() {
		return ParentType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [ParentType=" + ParentType + ", totalChilds="
				+ totalChilds + "]";
	}

	/**
	 * @return the totalChilds
	 */
	public int getTotalChilds() {
		return totalChilds;
	}
}