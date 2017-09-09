package chapter_3;

public class Problem_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums;
		nums = new int[7];
		
		int[] nums2 = new int[7];
		
		for(int i = 0; i < 7; i++) {
			nums[i] = i;
			nums2[i] = i*2;
		}

		for(int i = 0; i < 7; i++) {
		System.out.print(nums[i]+" ");
		}
		System.out.println("");
		
		dog[] pets = new dog[7];
		System.out.println("pets length: " + pets.length);
		pets[0] = new dog(4,"xiaohei");
		int a = 0;
		System.out.println("pets[" + a + "] : name is "+ pets[a].showName() + ", age is "+ pets[a].showAge()
				+ ".");
		pets[a].bark();
		
		
	}

}
