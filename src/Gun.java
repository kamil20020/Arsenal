import java.io.Serializable;

public class Gun implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int version;
	private double caliber;
	private int magazineSize;
	private double weight;
	private int numberOf;

	public enum Type{
		Shogun,
		Pistol,
		Rifle
	};
	
	private Type type;
	
	public Gun(String name, int version, double caliber, int magazineSize, double weight, Gun.Type type, int numberOf) {
		
		this.name = name;
		this.version = version;
		this.caliber = caliber;
		this.magazineSize = magazineSize;
		this.weight = weight;
		this.type = type;
		this.numberOf = numberOf;
	}
	
	public void setVersion(int version) {
		
		this.version = version;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return name;
	}
	
	public int getVersion() {
		
		return version;
	}

	public double getCaliber() {
		
		return caliber;
	}

	public void setCaliber(double caliber) {
		
		this.caliber = caliber;
	}

	public int getMagazineSize() {
		return magazineSize;
	}

	public void setMagazineSize(int magazineSize) {
		
		this.magazineSize = magazineSize;
	}

	public double getWeight() {
		
		return weight;
	}

	public void setWeight(float weight) {
		
		this.weight = weight;
	}

	public Type getType() {
		
		return type;
	}

	public void setType(Type type) {
		
		this.type = type;
	}
	
	public int getNumberOf() {
		
		return numberOf;
	}
	
	public void setNumberOf(int numberOf) {
		
		this.numberOf = numberOf;
	}
	
	public static String getString(String name, int version, double caliber) {
		
		return name + "-" + version + " cal " + caliber + "mm";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null)
			return false;
		
		if(obj == this)
			return true;
		
		if(!(obj instanceof Gun))
			return false;
		
		Gun otherGun = (Gun) obj;
		
		if(name.equals(otherGun.name) && version == otherGun.version && caliber == otherGun.caliber)
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return 17*name.hashCode() + 31*version + 7*Double.valueOf(caliber).hashCode();
	}

	@Override
	public String toString() {
		
		return name + "-" + version + " cal " + caliber + "mm";
	}
}
