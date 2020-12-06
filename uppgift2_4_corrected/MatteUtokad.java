package uppgift2_4_corrected;

public class MatteUtokad {


	@SuppressWarnings("unused")
	private String name;

	private KattUtokad katt;
	
	
	public MatteUtokad(String owners_name, KattUtokad mycat ) {
		this.name= owners_name;
		this.katt= mycat;
	
	}
	
	public static void main(String[] args) {
	KattUtokad  katt = new KattUtokad("Magnus", "kittie",2,"maine coon", "cat");
	 MatteUtokad matte = new MatteUtokad("Kalle", katt);
	 
	System.out.println("The name of the pet is: "+ matte.katt.getName()+"\n"+
	matte.katt.getName()+ " is a "+ matte.katt.getPet()+".\n"
	+ matte.katt.getName()+"'s age is "+ matte.katt.getAge()+ " months old."+ "\nIts race is: "+
	matte.katt.getRace()+".\n"+ "The name of the owner is: "+matte.katt.getOwner()+".");	
	
	}	
	

}
