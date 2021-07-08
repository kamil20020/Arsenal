import java.io.Serializable;

public class Gun implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int version;
	private double caliber;
	private int magazineSize;
	private double weight;

	public enum Type{
		Shogun,
		Pistol,
		Rifle
	};
	
	private Type type;
	
	public Gun(String name, int version, double caliber, int magazineSize, double weight, Type type) {
		
		this.name = name;
		this.version = version;
		this.caliber = caliber;
		this.magazineSize = magazineSize;
		this.weight = weight;
		this.type = type;
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

	public void setCaliber(float caliber) {
		
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
	
	@Override
	public String toString() {
		
		return name + "-" + version + "_" + caliber;
	}
}
