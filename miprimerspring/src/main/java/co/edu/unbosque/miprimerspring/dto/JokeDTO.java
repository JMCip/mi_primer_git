package co.edu.unbosque.miprimerspring.dto;

public class JokeDTO {

	private boolean error;
	private String category;
	private String type;
	private String joke;
	private String setup;
	private String delivery;
	private FlagsDTO flags;
	private boolean safe; 
	private int id;
	private String lang;

	public JokeDTO() {
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJoke() {
		return joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}

	public String getSetup() {
		return setup;
	}

	public void setSetup(String setup) {
		this.setup = setup;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public FlagsDTO getFlags() {
		return flags;
	}

	public void setFlags(FlagsDTO flags) {
		this.flags = flags;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "JokeDTO [\n" + "  error=" + error + "\n" + "  category=" + category + "\n" + "  type=" + type + "\n"
				+ "  joke=" + joke + "\n" + "  setup=" + setup + "\n" + "  delivery=" + delivery + "\n" + "  flags="
				+ flags + "\n" + "  safe=" + safe + "\n" + "  id=" + id + "\n" + "  lang=" + lang + "\n]";
	}
}