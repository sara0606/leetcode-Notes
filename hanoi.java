//https://www.lintcode.com/problem/tower-of-hanoi/description

public class Solution {
    /**
     * @param n: the number of disks
     * @return: the order of moves
     */
    public List<String> towerOfHanoi(int n) {
        // write your code here
        List<String> ls =new LinkedList<>();
        if(n<1) return null;
        return move(n,"A","B","C",ls);
        
    }
  public  List<String> move(int n , String a ,String b ,String c,List<String> ls)
	{
	 
		if(n<1)
		{
			return null;
		}
		else if(n == 1)
		{
		    //ls.add(String.format("from %s to %s",a,c))£»
			ls.add("from " + a + " to " + c);
			return ls;
		}
		else
		{
			this.move(n-1, a, c, b,ls);
			this.move(1,a,b,c,ls);
			this.move(n-1, b, a, c,ls);

		}
		return ls;
	}
    
}