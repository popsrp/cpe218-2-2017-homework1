import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;
import java.util.Scanner;

public class Homework1 {

	public static ByteArrayOutputStream baos = new ByteArrayOutputStream();
	public static PrintStream ps = new PrintStream(baos);
	public static Tree puy;
	// IMPORTANT: Save the old System.out!

	// Tell Java to use your special stream


	static class  Tree {
		public Tree left;
		public Tree right;
		public Character key;
		public Tree(Character n)
		{
			key=n;
		}
		public String toString(){
			return key.toString();
		}
	}

	public static Tree trees;
	public static Stack<Character> popy=new Stack<Character>();
	public static void main(String[] args) {
		// Begin of arguments input sample
		System.out.print("Question = ");
		Scanner Poppied = new Scanner(System.in);
		String input = Poppied.nextLine();
		for (int i = 0; i < input.length(); i++) {
			popy.add(input.charAt(i));
		}
		PrintStream old = System.out;
		System.setOut(ps);
		trees=new Tree(popy.pop());
		puy=trees;
		infix(trees);
		inOrder(trees);
		System.out.println("="+calculate(trees));
		// TODO: Implement your project here
	    TreeDemo.main(args);
	}
	public static void inOrder(Tree n)
	{
		if(n.key=='+'||n.key=='-'||n.key=='*'||n.key=='/')
		{
			if(n!=puy) System.out.print("(");
			inOrder(n.left);
			System.out.print(n.key);
			inOrder(n.right);
			if(n!=puy) System.out.print(")");
		}else
		{
			System.out.print(n.key);
		}
	}
	public static void infix(Tree n)
	{
		if(n.key=='+'||n.key=='-'||n.key=='*'||n.key=='/')
		{
			n.right=new Tree(popy.pop());
			infix(n.right);
			n.left=new Tree(popy.pop());
			infix(n.left);
		}
	}
	public static int calculate(Tree n)
	{
		if(n.key=='+')return calculate(n.left)+calculate(n.right);
		else if(n.key=='-')return calculate(n.left)-calculate(n.right);
		else if(n.key=='*')return calculate(n.left)*calculate(n.right);
		else if(n.key=='/')return calculate(n.left)/calculate(n.right);
		else return Integer.parseInt(n.key.toString());
	}
}

