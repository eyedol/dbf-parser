package jdbf.parser.sample;

public class StockDbfModel {
  public String price1;
  public String desc;

  public StockDbfModel(String price1, String desc) {
    this.price1 = price1;
    this.desc = desc;
  }

  @Override public String toString() {
    return "StockDbfModel{" + "price1='" + price1 + '\'' + ", desc='" + desc + '\'' + '}';
  }
}
