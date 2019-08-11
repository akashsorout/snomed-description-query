package in.co.bytehub.snomed.searchapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.co.bytehub.snomed.searchapi.model.Description;
import in.co.bytehub.snomed.searchapi.service.LoaderService;

@SpringBootApplication
public class SnomedDescriptionQueryApplication implements CommandLineRunner {

	private static final int Offset = 400000;

	@Autowired
	private ConfigurableApplicationContext context;

	@Autowired
	private LoaderService loaderServ;

	public static void main(String[] args) {

		SpringApplication.run(SnomedDescriptionQueryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Long start = System.currentTimeMillis();

		File descriptionFile = new File(
				"C:\\Users\\g522257\\Downloads\\SnomedCT_InternationalRF2_PRODUCTION_20190131T120000Z\\SnomedCT_InternationalRF2_PRODUCTION_20190131T120000Z\\Snapshot\\Terminology\\sct2_Description_Snapshot-en_INT_20190131.txt");

		BufferedReader bufferReader = new BufferedReader(new FileReader(descriptionFile));

		Long skipNum = 1L;

		Stream<String> firstStream = bufferReader.lines().skip(skipNum).limit(Offset);
		skipNum += Offset;
		Stream<String> secondStream = bufferReader.lines().limit(Offset);
		skipNum += Offset;
		Stream<String> thirdStream = bufferReader.lines().limit(Offset);
		skipNum += Offset;
		Stream<String> forthStream = bufferReader.lines().limit(Offset);

		System.err.println("Four Streams Ready : " + (System.currentTimeMillis() - start));

		loaderServ.loadData(firstStream.map(this::toDescription).collect(Collectors.toList()));

		System.err.println("First Stream Data loaded Time : " + (System.currentTimeMillis() - start));

		loaderServ.loadData(secondStream.map(this::toDescription).collect(Collectors.toList()));

		System.err.println("Second Stream Data loaded Time : " + (System.currentTimeMillis() - start));

		loaderServ.loadData(thirdStream.map(this::toDescription).collect(Collectors.toList()));

		System.err.println("Third Stream Dataloaded Time : " + (System.currentTimeMillis() - start));

		loaderServ.loadData(forthStream.map(this::toDescription).collect(Collectors.toList()));

		Long complete = System.currentTimeMillis();

		System.err.println("Total Time : " + (complete - start));
		bufferReader.close();
	}

	public Description toDescription(String str) {

		String[] descElements = str.split("\t");
		Description descObject = new Description();
		descObject.setId(descElements[0]);
		descObject.setEffectiveTime(descElements[1]);
		descObject.setActive(Integer.parseInt(descElements[2]));
		descObject.setModuleId(descElements[3]);
		descObject.setConceptId(descElements[4]);
		descObject.setLanguageCode(descElements[5]);
		descObject.setTypeId(descElements[6]);
		descObject.setTerm(descElements[7]);
		descObject.setCaseSignificanceId(descElements[8]);
		return descObject;
	}
}
