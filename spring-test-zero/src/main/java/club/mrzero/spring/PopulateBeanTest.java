package club.mrzero.spring;

/**
 * @author LinWeiYu
 * @date 2021/6/8 17:02
 */
public class PopulateBeanTest {

	private String name;

	public PopulateBeanTest(String name) {
		this.name = name;
	}

	public PopulateBeanTest() {
	}

	@Override
	public String toString() {
		return "PopulateBeanTest{" +
				"name='" + name + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
