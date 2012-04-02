/**
 *  
 */
package ravid.java.programs.basic;

import org.apache.commons.lang.StringUtils;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test suite for {@link ExcelColumnTranslation}
 *
 * @author Ravi
 */
public class ExcelColumnTranslationTest extends TestCase {

	private ExcelColumnTranslation translation = 
		new ExcelColumnTranslation();
	
	/**
	 * Test method for {@link ravid.java.programs.basic.ExcelColumnTranslation#excelColumnInInt(java.lang.String)}.
	 */
	public final void testExcelColumnInInt() {
		Assert.assertTrue(translation.excelColumnInInt("AA99a") == 703);
		Assert.assertTrue(translation.excelColumnInInt("AAA") == 703);
		Assert.assertTrue(translation.excelColumnInInt("DY") == 129);
		Assert.assertTrue(translation.excelColumnInInt("Z") == 26);
		Assert.assertTrue(translation.excelColumnInInt("B") == 2);
		Assert.assertTrue(translation.excelColumnInInt("") == 0);
		Assert.assertTrue(translation.excelColumnInInt(null) == 0);
		Assert.assertTrue(translation.excelColumnInInt("999") == 0);
	}
	
	/**
	 * Test method for {@link ravid.java.programs.basic.ExcelColumnTranslation#intToExcelColumn(int)}
	 */
	public final void testIntToExcelColumn() {
		Assert.assertTrue(StringUtils.equals(translation.intToExcelColumn(1), "A"));
		Assert.assertTrue(StringUtils.equals(translation.intToExcelColumn(27), "AA"));
		Assert.assertTrue(StringUtils.equals(translation.intToExcelColumn(53), "BA"));
		Assert.assertTrue(StringUtils.equals(translation.intToExcelColumn(703), "AAA"));
	}
}
