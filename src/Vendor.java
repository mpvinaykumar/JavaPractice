import java.io.File;
import java.io.FileWriter;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

public class Vendor extends AbsParent {
	private static final Pattern excelPattern = Pattern.compile(".*(Placement ID|PLACEMENT ID)");

	// private String s1 = new String("xls|xlsx");
	@Override
	void m2() {
		System.out.println("in Abs-M2");
	}

	@Override
	void m3() {
		System.out.println("in Abs-M3");
	}

	public static void main(String[] args) {
		try {
			System.out.println((UUID.randomUUID() + "").length());;
			File file = new File("D://AdvUpload/59/7e2e0d77_e069_4a0c_b5f6_d9ce1af88a6e_20181108_BKYGP6mioCRuIXR33ry2DjijzztaDat0W3a69ahjL9rqSQTp25wfnWVhKM7viB8p3oqpriaGnlgwQThweCVfAnP4c2jg5XjCdAInpAsfSGpIZ9I3HWoGC6xEdKFqbkMwszF5M5zQlefnvro5EQWSmAmAk13oW1uzv7eRhMyY4DxisxGnxaddnTgxyGsbWwuYYfbjbfaOD7WITH255.html");

			// Create the file
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}

			// Write Content
			FileWriter writer = new FileWriter(file);
			writer.write("Test data");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Vendor abs = new Vendor(); abs.m1();
		 * System.out.println(excelPattern.matcher("PLACEMENT ID").matches());
		 * System.out.println(BulkUploadType.valuesToEnums.toString());
		 */
	}

}

abstract class AbsParent {
	void m1() {
		System.out.println("in Parent-M1");
		this.m2();
		this.m3();
	}

	abstract void m2();

	abstract void m3();
}

enum BulkUploadType {
	DCM("DCM"), PULSEPOINT("PulsePoint"), SIZMEK("Sizmek"), DV("DV");

	public static final Map<String, BulkUploadType> valuesToEnums;

	static {
		valuesToEnums = new HashMap();
		for (BulkUploadType e : EnumSet.allOf(BulkUploadType.class)) {
			valuesToEnums.put(e.type, e);
		}
	}

	private String type;

	private BulkUploadType(String type) {
		this.type = type;
	}

	public String getEntityValue() {
		return type;
	}
}
