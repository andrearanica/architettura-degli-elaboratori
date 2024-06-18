
public class Paragraph extends DocumentItem {
	private String text;
	
	public Paragraph(String text) throws NonValidDocumentException {
		if (text == null || text.isBlank()) {
			throw new NonValidDocumentException("Text is null");
		} else {
			this.text = text;
			this.setLock(false);
		}
	}
	
	public void update(DocumentItem other) throws ModifyingLockedDocumentException {
		if (this.isLocked()) {
			throw new ModifyingLockedDocumentException();
		} else {
			this.text = other.getText();
		}
	}
	
	public String getText() {
		return this.text;
	}
}
