public class Person implements Comparable<Person>
{
	private static class Identity {
		public final static String DEFAULT_PRONOUNS = "N/A";
		public final static String DEFAULT_BACKGROUND = "N/A";		
		
		private String pronouns;
		private String background;

		public Identity() {
			this(DEFAULT_PRONOUNS, DEFAULT_BACKGROUND);
		}
		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		public void setAll(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}
		public String getPronouns() {
			return this.pronouns;
		}

		public String getBackground() {
			return this.background;
		}
		@Override
		public String toString() {
			return "Pronouns: " + this.pronouns + " Background: " + this.background;
		}
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Identity))  {
				return false;
			}
			
			Identity i = (Identity) o;

			if (i.getPronouns() == this.getPronouns() && i.getBackground() == this.getBackground()) {
				return true;
			}

			else{
				return false;
			}
				

		}
	}

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final Identity DEFAULT_STORY =  new Identity();
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity story;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		Identity i = new Identity(pronouns, background);
		this.setAll(name, i, privilege);
	}
		
	public Person() {
		this.name = DEFAULT_NAME;
		this.story = new Identity();
		this.privilege = DEFAULT_PRIVILEGE;
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setStory(Identity story) {
		this.story = story;
	}

	public void updateStory(String pronouns, String background) {
		this.story.setAll(pronouns, background);
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, Identity story, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setStory(story);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public Identity getStory() {
		return this.story;
	}

	public String getStoryDetails() {
		return this.story.toString();

	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + ", my personal pronouns are "+ this.story.getPronouns() + " and " + this.story.getBackground() + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		      return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/

	@Override
	public int compareTo(Person other) {
		
		int result = -2;

		if (!(other == null)) {

			if (this.getPrivilege() > other.getPrivilege()) {
				result = 1;
			} else if (this.getPrivilege() < other.getPrivilege()) {
				result = -1;
			} else if (this.getPrivilege() == other.getPrivilege()) {
				result = 0;
			}
		}

		return result;
			
		}
		
		
	}
