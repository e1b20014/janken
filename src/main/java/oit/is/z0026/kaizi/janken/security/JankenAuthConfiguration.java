package oit.is.z0026.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class JankenAuthConfiguration {

  /**
   * 認証処理に関する設定（誰がどのようなロールでログインできるか）
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    // このクラスの下部にあるPasswordEncoderを利用して，ユーザのビルダ（ログインするユーザを作成するオブジェクト）を作成する
    UserBuilder users = User.builder();

    // UserBuilder usersにユーザ名，パスワード，ロールを指定してbuildする
    // このときパスワードはBCryptでハッシュ化されている．
    // ハッシュ化されたパスワードを得るには，この授業のbashターミナルで下記のように末尾にユーザ名とパスワードを指定すると良い(要VPN)
    // $ sshrun htpasswd -nbBC 10 user1 isdev
    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$vDlByoqwpSXr8ZjBdvrZpuviHI0t5EGd2E48cmo3MLDHWmGVSdxty")
        .roles("USER")
        .build();
    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$J/VSUq/LukU18oTnEXu5GOXpcSSqfWiWYlUOnLmBmdtrR21pkRX6W")
        .roles("USER")
        .build();
    UserDetails user3 = users
        .username("ほんだ")
        .password("$2y$10$KV6mcfZlXFIuWrWZnaR74.M2gOqULoqldsLP/18oTPTJvuF1aOXeu")
        .roles("USER")
        .build();
         UserDetails user4 = users
        .username("いがき")
        .password("$2y$10$KV6mcfZlXFIuWrWZnaR74.M2gOqULoqldsLP/18oTPTJvuF1aOXeu")
        .roles("USER")
        .build();
    // 生成したユーザをImMemoryUserDetailsManagerに渡す（いくつでも良い）
    return new InMemoryUserDetailsManager(user1, user2, user3, user4);
  }

  /**
   * 認可処理に関する設定（認証されたユーザがどこにアクセスできるか）
   *
   * @param http
   * @return
   * @throws Exception
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // Spring Securityのフォームを利用してログインを行う（自前でログインフォームを用意することも可能）
    http.formLogin();

    // http://localhost:8080/sample3 で始まるURLへのアクセスはログインが必要
    // mvcMatchers().authenticated()がmvcMatchersに指定されたアクセス先に認証処理が必要であることを示す
    // authenticated()の代わりにpermitAll()と書くと認証不要となる
    http.authorizeHttpRequests()
        .mvcMatchers("/janken/**").authenticated();

    http.logout().logoutSuccessUrl("/"); // ログアウト時は "http://localhost:8000/" に戻る
    
    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  /**
   *
   * UserBuilder users = User.builder();で利用するPasswordEncoderを指定する．
   *
   * @return BCryptPasswordEncoderを返す
   */
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
