package jdbf.parser.sample;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import net.iryndin.jdbf.core.DbfMetadata;
import net.iryndin.jdbf.core.DbfRecord;
import net.iryndin.jdbf.reader.DbfReader;

public class StockDbfParser {

  public static void main(String args[]) throws Exception {
    StockDbfParser stockDbfParser = new StockDbfParser();
    stockDbfParser.readDBF();
  }

  public void readDBF() throws IOException, ParseException {
    Charset stringCharset = Charset.forName("Cp866");
    String home = System.getProperty("user.home");
    File file = new File(home + "/stock.dbf");
    DbfRecord rec;
    List<List<StockDbfModel>> maps = new ArrayList<>();
    try (DbfReader reader = new DbfReader(file)) {
      DbfMetadata meta = reader.getMetadata();
      while ((rec = reader.read()) != null) {
        rec.setStringCharset(stringCharset);
        List<StockDbfModel> list = new ArrayList<>();
        list.add(new StockDbfModel(rec.getString("PRICE1"), rec.getString("DESC")));
        maps.add(list);
      }
      reader.close();
    }

    for (List<StockDbfModel> item : maps) {
      for (StockDbfModel model : item) {
        System.out.println("Price = " + model.price1 + ", Description = " + model.desc);
      }
    }
  }
}
