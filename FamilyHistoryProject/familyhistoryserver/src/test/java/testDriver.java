

/**
 * Created by Admin on 2/28/17.
 */


public class testDriver {


    public static void main(String[] args) {
//        org.junit.runner.JUnitCore.runClasses(
//                dataaccess.DatabaseTest.class,
//                spellcheck.URLFetcherTest.class,
//                spellcheck.WordExtractorTest.class,
//                spellcheck.DictionaryTest.class,
//                spellcheck.SpellingCheckerTest.class
//                );



        org.junit.runner.JUnitCore.main(
                "dataAccessTest.databaseTest",
                "proxyTest.proxyTest");
    }
}
