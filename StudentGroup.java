import java.util.Date;
import java.util.Scanner;  
import java.text.SimpleDateFormat;
import java.lang.RuntimeException;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		
		if(students.length >0){
			
			for(int index=0;index<students.length;index++){
				System.out.println("id "+students[index].getId());
			}
			
			return students;
		}
			
		else
			throw new IllegalArgumentException("object is null");
		
	}

	@Override
	public void setStudents(Student[] students) {
		
		if(students ==null){
			throw new IllegalArgumentException("object is null");
		}
		else{
			
			int temp =this.students.length,index;
			
			for(index=0;index<students.length;index++){
				this.students[temp++] =students[index];
			}
			
			
		}
	}

	@Override
	public Student getStudent(int index) {
		
		if(index<0 || index > students.length)
			throw new IllegalArgumentException("object is null");
		
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		
		if(index<0 || index > students.length)
			throw new IllegalArgumentException("object is null");
		
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		
		if(student ==null)
			throw new IllegalArgumentException("object is null");
		
		int temp =students.length;
		int index;
		
		for(index=temp;index>0;index--){
			students[index] =students[index-1];
		}
		
		students[0] =student;
	}

	@Override
	public void addLast(Student student) {
		
		if(student ==null)
			throw new IllegalArgumentException("object is null");
		
		students[students.length] =student;
	}

	@Override
	public void add(Student student, int index) {
		
		if(student ==null || index<0 || index > students.length)
			throw new IllegalArgumentException("object is null");
		
		int temp =students.length,index1;
		
		for(index1=0;index1>index;index--){
			students[index1] =students[index1-1];
		}
		
		students[index] =student;
	}

	@Override
	public void remove(int index) {
		
		if(index<0 || index > students.length)
			throw new IllegalArgumentException("object is null");
		
		int index1;
		
		for(index1=index;index1<students.length-1;index1++){
			students[index1] =students[index1+1];
		}
	}

	@Override
	public void remove(Student student) {
		
		if(student ==null)
			throw new IllegalArgumentException("object is null");
		
		int res =-1,index;
		
		for(index=0;index<students.length;index++){
			
			if(students[index].equals(student)){
				res =index;
			}
		}
		
		if(res ==-1)
			throw new IllegalArgumentException("Student not exist");
		else
			remove(res);
		
	}

	@Override
	public void removeFromIndex(int index) {
		
		if(index<0 || index > students.length)
			throw new IllegalArgumentException("object is null");
		
		//students.length =index+1;
		Student temp[] =new Student[index+1];
		int index1;
		
		for(index1=0;index1<=index;index1++){
			temp[index1] =students[index1];
		}
		
		students =temp;
	}

	@Override
	public void removeFromElement(Student student) {
		
		if(student ==null)
			throw new IllegalArgumentException("object is null");
		
		int res =-1,index;
		
		for(index=0;index<students.length;index++){
			
			if(students[index].equals(student)){
				res =index;
			}
		}
		
		if(res ==-1)
			throw new IllegalArgumentException("Student not exist");
		else
			removeFromIndex(res);
	}

	@Override
	public void removeToIndex(int index) {
		
		if(index<0 || index > students.length)
			throw new IllegalArgumentException("object is null");
		
		int temp1=0,index1;
		Student temp[] =new Student[index+1];
		for(index1=index;index1<students.length;index1++){
			temp[temp1++] =students[index1];
		}
		
		students =temp;
	}

	@Override
	public void removeToElement(Student student) {
		
		if(student ==null)
			throw new IllegalArgumentException("object is null");
		
		int res =-1,index;
		
		for(index=0;index<students.length;index++){
			
			if(students[index].equals(student)){
				res =index;
			}
		}
		
		if(res ==-1)
			throw new IllegalArgumentException("Student not exist");
		else
			removeToIndex(res);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		
		double max =-1,am;
		int index;
		
		for(index=0;index<students.length;index++){
			am =students[index].getAvgMark();
			if(max < am){
				max =am;
			}
		}
		
		Student res[] =new Student[students.length];
		int temp=0;
		
		for(index=0;index<students.length;index++){
			am =students[index].getAvgMark();
			if(max == am){
				res[temp++] =students[index];
			}
		}
		
		return res;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
