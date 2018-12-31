//Project 3
//Afreen Hameed  
//CS113H
/*
	This code verifies Goldbach's conjecture for the first 500000 even integers
	
	Goldbach's conjecture is one of the oldest and best-known unsolved problems
	in number theory and all of mathematics. It states: Every even integer greater 
	than 2 can be expressed as the sum of two primes. -Wikipedia 
*/
public class Goldbach {

	public static void main(String[] args) {
		
		int[] test=new int[1000000];
		int[] integer=new int[1000000-4];
		goldbach(integer);
		sieve(test);
		
		for(int value:test){
			System.out.print(value+" ");
		}
		
		

	}
	public static void sieve(int[] array){
		int i;
		
		array[0]=0; //skip 1
		
		for(i=1;i<array.length;i++){
			array[i]=i+1;
		}//creates array 2-25
		
		for(int index=0; index<Math.sqrt(array.length);index++){
			
			if(array[index]==0){
				continue;
			}
			else{
				int n=index;
				while((n+index+1)<array.length){
					n=n+index+1;
					array[n]=0;
				}
				
			}
		}
		
	}
	public static void goldbach(int[] array){
		boolean helper;
		for(int i=0, c=0;i<array.length;i++,c=c+2){
			array[i]=4+c;
		}
		
		int[] parray=new int[array.length+4];
		sieve(parray);
		
		for(int value:array){
			
			for(int a=1;a<parray.length;a++){
				helper=false;
				for(int b=1;b<parray.length;b++){
					if(parray[a]+parray[b]==value){
						System.out.println(parray[a]+"+"+parray[b]+"="+value);
						helper=true;
						break;
						
					}
				}
				if(helper){
					break;
				}
			}
		}
	}
}

