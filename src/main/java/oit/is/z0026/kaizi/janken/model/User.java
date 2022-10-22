package oit.is.z0026.kaizi.janken.model;

public class User {
  int id;
  String name;

  // Thymeleafでフィールドを扱うためにはgetter/setterが必ず必要
  // Thymeleafはgetのあとには変数名(5行目)みたいなNameだけにする
  // vscodeのソースコード右クリック->ソースアクションでsetter/getterを簡単に追加できる
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
