package TowerOfHanoi;

public interface StackInterface<E>
{
	public void push(E o);
	public E peek();
	public E pop();
	public boolean empty();
	
	public int size();
	public E get(int x);
}