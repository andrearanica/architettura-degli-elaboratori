import java.util.ArrayList;

public class Document extends DocumentItem {
	private ArrayList<DocumentItem> sections;
	
	public Document(DocumentItem begin) throws NonValidDocumentException {
		if (begin == null) {
			throw new NonValidDocumentException("Document is null");
		} else {
			this.setLock(false);
			this.sections = new ArrayList<DocumentItem>();
			this.sections.add(begin);
		}
	}
	
	public void update(DocumentItem other) throws ModifyingLockedDocumentException {
		if (this.isLocked()) {
			throw new ModifyingLockedDocumentException("Document is locked");
		} else {
			this.sections.add(other);
		}
	}
	
	public void update(DocumentItem other, int cursor) throws ModifyingLockedDocumentException {
		if (cursor < 0 || cursor >= this.sections.size()) {
			this.sections.add(other);
		} else {
			if (this.sections.get(cursor).isLocked()) {
				throw new ModifyingLockedDocumentException();
			} else {
				this.sections.get(cursor).update(other);
			}
		}
	}
	
	public String getText() {
		String text = "";
		for (DocumentItem item: this.sections) {
			text += item.getText();
		}
		return text;
	}
}
