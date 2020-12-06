package uppgift2_2_corrected;

public class Matte {

	private String name;

	private Katt katt;
	
	
	public Matte(String owners_name, Katt mycat ) {
		this.name= owners_name;
		this.katt= mycat;
	
	}
	
	public static void main(String[] args) {
	Katt  katt = new Katt("kittie",2,"maine coon", "cat");
	 Matte matte = new Matte("Kalle", katt);
	 
	System.out.println("The name of the owner is: "+ matte.name+"\n"+
	matte.name+"'s pet is a "+ matte.katt.getPet()+"."
	+ "\nThe name of the "+ matte.katt.getPet()+ " is: "+ matte.katt.getName()+"\n"+
	matte.katt.getName()+"'s age is "+ matte.katt.getAge()+ " months old."+ "\nIts race is: "+
	matte.katt.getRace()+".");	
	
	}
	
    }
    
	