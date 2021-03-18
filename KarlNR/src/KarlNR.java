
public class KarlNR {

	public static void main(String[] args){
		
		System.out.println(calc(950));  // 95016
		System.out.println(calc(110));  // 1103
		System.out.println(calc(1500));  // 150029
		System.out.println(calc(910));  // 9105
	}
	
	public static int calc(int q){
	
		int a = 0;
		int b = 0;
		int c = 0;
		int n = 0;
		int x = 1;
		int m = 1;
		
		String temp = Integer.toString(q);
		
		int[] w = new int[temp.length()];
		
		for (int i = 0; i < temp.length(); i++){
			if(i>=2 && w[i] == 0){
				n++;
			}
		    w[i] = temp.charAt(i) - '0';
		}
		
		a = w[0];		
		b = w[1];
		
		if(a==0 && b==0){
			return 0;
		}
		
		while(x/m>=1){
			
			m = m*10;
			c++;
			
			x = Math.abs(a - b*(n+2+c));
		
		}
		
		int[] ans = new int[temp.length() + Integer.toString(x).length()];
		
		for(int i = temp.length(); i > 1; i--){
			ans[i] = 0;
		}
		ans[0] = a;
		ans[1] = b;
		
		int j = 0;
		for(int i = temp.length(); i < temp.length() + Integer.toString(x).length(); i++){
			ans[i] = Integer.parseInt(Integer.toString(x).substring(j, j+1));
			j++;
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ans.length; i++){
			sb.append(Integer.toString(ans[i]));
		}
	return Integer.parseInt(sb.toString());
	
	}
}
