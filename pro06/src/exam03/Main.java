package exam03;

public class Main {

	public static void main(String[] args) {
		Person[] pArr = new Person[4];
		
		Person p1 = new Person();
		p1.setName("홍길동");
		System.out.println(p1.getName());
		
		Person p2 = new Person();
		p2.setName("박지수");
		System.out.println(p2.getName());
		
		Person p3 = new Person();
		p3.setName("김주언");
		System.out.println(p3.getName());
		
		pArr[0] = p1;
		pArr[1] = p2;
		pArr[2] = p3;
		pArr[3] = new Person();
		pArr[3].setName("이수연");

		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
		
		PersonList pList = new PersonList(pArr);
		System.out.println(pList.get(0));
		
		for(int i = 0; i < pList.length(); i++) {
			Person p = pList.get(i);
			System.out.println(p.getName());
		}
		int idx = pList.findIndex("박지수");
		
		boolean isExisted = pList.existsName("박지수");
		
		System.out.println(idx + " " + isExisted);
		
		pList.add(new Person("곽도운"));
		pList.addFirst(new Person("강지원"));
		
		System.out.println(pList.findIndex("곽도운"));
		System.out.println(pList.findIndex("강지원"));
		
		System.out.println(pList.get(1).getName());
		pList.remove(1);
		System.out.println(pList.get(1).getName());
		
		System.out.println(pList.findIndex("박지수"));
		pList.remove("박지수");
		System.out.println(pList.findIndex("박지수"));
	}

}
