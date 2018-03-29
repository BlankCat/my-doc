import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @author  zjf
 * @date 创建时间：2018年3月29日 
 * @Description System.getProperties() 方法得到系统所有属性的全部输出一览
 * http://www.mikewootc.com/
 * 对所做的事情的理解越深, 你就会做的越好.
 * java 系统属性，编码格式
 * 
 */
public class TestJvm {

  public static void main(String[] args) {
    printSysEncoding();
//    Properties props= System.getProperties();
//    System.out.println(props.size());
//    for(Object o:props.keySet()){
//      System.out.println(o + "==" + props.get(o));
//    }
  }
  
  public static void printSysEncoding(){
    //获取系统默认编码    
    System.out.println(System.getProperty("file.encoding"));
    
    //获取系统默认字符编码
    System.out.println(Charset.defaultCharset());
    
    //获取系统默认语言  
    System.out.println(System.getProperty("user.language"));
    
    //获取系统属性列表
//    System.getProperties().list(System.out);

    //设置编码
    System.getProperties().put("file.encoding", "GBK");
    
    
    
    
  }
  
  /*
   * 
   *  props.getProperty("java.version");具体有那些属性，参照下边。
      java.version  Java 运行时环境版本
      java.vendor  Java 运行时环境供应商
      java.vendor.url  Java 供应商的 URL
      java.home  Java 安装目录
      java.vm.specification.version  Java 虚拟机规范版本
      java.vm.specification.vendor  Java 虚拟机规范供应
      java.vm.specification.name  Java 虚拟机规范名称
      java.vm.version  Java 虚拟机实现版本
      java.vm.vendor  Java 虚拟机实现供应商
      java.vm.name  Java 虚拟机实现名称
      java.specification.version  Java 运行时环境规范版本
      java.specification.vendor  Java 运行时环境规范供应商
      java.specification.name  Java 运行时环境规范名称
      java.class.version  Java 类格式版本号
      java.class.path  Java 类路径
      java.library.path  加载库时搜索的路径列表
      java.io.tmpdir  默认的临时文件路径
      java.compiler  要使用的 JIT 编译器的名称
      java.ext.dirs  一个或多个扩展目录的路径
      os.name  操作系统的名称
      os.arch  操作系统的架构
      os.version  操作系统的版本
      file.separator  文件分隔符（在 UNIX 系统中是“/”）
      path.separator  路径分隔符（在 UNIX 系统中是“:”）
      line.separator  行分隔符（在 UNIX 系统中是“/n”）
      user.name  用户的账户名称
      user.home  用户的主目录
      user.dir  用户的当前工作目录
   * 
   * 
   */
}
