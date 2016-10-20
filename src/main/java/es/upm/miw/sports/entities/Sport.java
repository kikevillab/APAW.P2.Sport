package es.upm.miw.sports.entities;

public class Sport {

	private int id;
	
    private String name;
    
    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }


	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Sport))return false;
	    Sport sport = (Sport) other;
	    if(sport.getName().equals(this.getName())) return true;
	    return false;
	}
}
