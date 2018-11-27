package jinx;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 微信公众号的一些操作
 */
public class WechatUtil {

    public static final String appId = "wxbb64b329460bb1cba";
    public static final String appSecret = "edf58a93d5c68c502f93b77f9a7c892b";
    public static final String accessToken = "16_GL-kMxmmcxhvbbiYGK0VOG2RQj9bCtiASdNnayDwh9B6lBvrdI5YUar5taNcJ-kn2z5wbP-zOXD-m5qVlfF6ZjQ-Ni8GiGFPw6c44g5R7qJBx_suj0xRAFNCkcsIVV4O1hb9nfA9GWFYL3zXLFRbAAAWQC";

    public static final String[] users = new String[]{"ozUjJ1c6JFYeS2g2lZ0krfiMEvAM","ozUjJ1R_hKbRJIV6Me6PkztKSkKY","ozUjJ1a7yGsF3VHb9DHJaPs7Sqy8","ozUjJ1ZZa8EG9QGo0l3Vl4dYd1dg","ozUjJ1dA40UXK3sk0yzpivrfHbZg","ozUjJ1ffOoN58ICB9KXGfOlr3VNA","ozUjJ1W-aUnGNi-8MONO1TXE4a8o","ozUjJ1VGTrgf42t3WPQidr16mr2k","ozUjJ1TdWeWR2hY2KSeRDYKMA7lQ","ozUjJ1TGZJOy5h2Tdib3kDuk1kd8","ozUjJ1YDhObGuZRvhWXYgJSFq7_w","ozUjJ1SudKRF-mqqDWjUU1MpKmF8","ozUjJ1btY9pc703RYRW3IIaZJ6Q4","ozUjJ1W8hQ0VRsM3K8ZXP0FBmuxc","ozUjJ1f5hW_JxcEkfJblB2pZNz1s","ozUjJ1dubjacOxVFjoXFsUFWcQMA","ozUjJ1d9N2fOKSyOAm52uu_25OBM","ozUjJ1a6qh0j6m5J4Q1QKYPKqTeo","ozUjJ1UeKueTfCgqNG7ZfRy6Zaxs","ozUjJ1e4RDMCinDdlpBByp6IdEpc","ozUjJ1QOWKbro2Uzg5tOIq73Bif8","ozUjJ1UeXMx-11HC-BmIwp938VX4","ozUjJ1WPlkUlsacmvo40uoTief-s","ozUjJ1R61DEDoIKkTyWyOVeLdTCo","ozUjJ1XfDrbEnD3MSOlcSt4hUiWw","ozUjJ1e6V6s7HubNp-m5RGguvXsk","ozUjJ1SEnn2GC8WrJ2ObMlay9qP4","ozUjJ1QG6D50kKVewEE8_TrBI5JU","ozUjJ1YP_6OP4VRBlMC_hrbODVa0","ozUjJ1bh7WOR5ce4WSao6r2ma17k","ozUjJ1VR1ZpGX-M8lrHEnsTlSC-M","ozUjJ1ddhtEJc8fLA_QLbRnNPsQ4","ozUjJ1Yw6UbUjPqQcOwLsCagcABA","ozUjJ1TRmZTAy26tBd5CefgPtgcc","ozUjJ1TnJIygDcGUgCcvmIPc5Z3w","ozUjJ1TmXLRYbInOJGCIvqXTRrEc","ozUjJ1aCPQQy76LxPTqpRWWVdjnM","ozUjJ1SeZDcSLJs7f-sr97x3PfF4","ozUjJ1fxIJD3UKayHUrmxrDbkA04","ozUjJ1UqaTxEnNyZO_KHF1LdjTV4","ozUjJ1R6ShOsGzvCuiCN2mahzuGM","ozUjJ1YRD9kVRE9So1735OGZmin0","ozUjJ1XtZZzR_aRqqltGm0aSHpj8","ozUjJ1V-XwpZMpwNbaOuU5pnNDiQ","ozUjJ1SQPQhg5HTIJmcu8PGTMWpI","ozUjJ1Q45zBWLWEpuAf0gL8bYVOM","ozUjJ1Qiit_jntF2xxxVl06tHnVc","ozUjJ1QlnGMmUAleA-ZlhZxbswxQ","ozUjJ1WbUK1iBSCYFMMa9iByMvwM","ozUjJ1Yz__4O2NXB20oRqyfwihmQ","ozUjJ1akPusMLmVGhWnSmKEYLIYw","ozUjJ1UQCsLjTWrWCSzTlhMaMjS8","ozUjJ1fypu6fuaqTqm-ZLsHzES9Q","ozUjJ1asBWoCs7mOCrGZMijgeYkM","ozUjJ1ZPQ6yag5f-bySTl84sCmtE","ozUjJ1Tj05woJhNMc2vsUkNB8ngw","ozUjJ1eC8pEYeqKlhVirkB2PWVl0","ozUjJ1T1k7Dhb6DafTlhXxtRCpUM","ozUjJ1YjzIcsdBvNIQk_aPATN6J4","ozUjJ1VHHVOiEXuU61JOCy0PP3TM","ozUjJ1aCbq67XvnMafuJDR1nuFZw","ozUjJ1Sjcn4K2nKn9SiQw-bEE8to","ozUjJ1RPl67rxxc9Qq6m4wth5z50","ozUjJ1WBy_XzoYxBDttrbNXtKNM0","ozUjJ1Sx5pLr1EVid0WOhX-KeQlE","ozUjJ1WBUGkJB2brrBkdPtX-nba0","ozUjJ1Uo8MUYcGkew1gRtliNqWYw","ozUjJ1btLH9j2u_RLEnnLsl60Onw","ozUjJ1Rb2van4eX8gyCrRAasLkhQ","ozUjJ1ZFqzXORdZcAB18a--4OFdw","ozUjJ1cPhNrKQEqx0eKZugJyj1c4","ozUjJ1Tp6a2W0yf16CXfsO-qBdbc","ozUjJ1UnkS3ZVofxd8sPxkK5-FIw","ozUjJ1esi94_EEsyU28Octams_RA","ozUjJ1UOoLB7d6pbZaWE-iZlzB4c","ozUjJ1cUhUs-r5-ZfUqlS2AgCdLI","ozUjJ1dcIlS5cZneIA4NOcOAqIak","ozUjJ1aN7E-11QNTvoWAIDCkLwqk","ozUjJ1QU3iwwW_KcsWS6Haa9u5t4","ozUjJ1Y08Iw96TcQyZ6xk5BO-j9c","ozUjJ1WVxk5rYn92L9SHPv1BMOzA","ozUjJ1U2Q-W7kiWnRLmwFqV_jNTw","ozUjJ1S6m3pIY1jlpp_3JalTh8io","ozUjJ1VwxVFGxBPr0iEtUQW9uKU8","ozUjJ1eScNSY75mO4GsiNf35k524","ozUjJ1QizN7apTeYH3zGRqkANXBY","ozUjJ1W9XEk8EYCKicpeLNigQ33U","ozUjJ1TaEGcga_VW5BmPnxIl6WLw","ozUjJ1WQRijnCbvAZfRdVogHc1TI","ozUjJ1c4yA42FTzKLasVNjHINaXg","ozUjJ1cwMoC2EMvTkIME8VTA_2BM","ozUjJ1dqTOd6tvkhvUi0KT0nATEg","ozUjJ1Vgm-yMiXR2URQ-JnL5-omc","ozUjJ1UDCeyKJ9viLD-X5CNbmoFI","ozUjJ1fx8BTIz3uKncmx-Him47S8","ozUjJ1Vl7eb2U4ywUhGtX8FAtpDQ","ozUjJ1SWD_dHbQI2NKUu40j1ZgwQ","ozUjJ1e4ZRNUcTr18zMsFNWfRZ3s","ozUjJ1a-5yxzcaTla0bE-zUqB1p0","ozUjJ1bb1DX6o3N46PAw2omAJ3uM","ozUjJ1ZAIUcDEy-Hs4C3jFuNOCSM","ozUjJ1WWH6ccznc2UrJdzdF2EqyY","ozUjJ1SvwVUL5Db-JNRJB4-J1Iak","ozUjJ1e2bjsZFaRCzP5W-zNJ03vk","ozUjJ1XOYIMZvr-vZQvEu3VxJF_8","ozUjJ1Xmcsp-oS5P636-LTj55xZQ","ozUjJ1bG1fBAhEyhFryKi-Ew6rU8","ozUjJ1WazfCzgDpTQnU4a2qq--aE","ozUjJ1QAYNz1hyKFw1b5idVic__g","ozUjJ1S6S7SBfjjb4JfCR8JZwicM","ozUjJ1QDbmmuPQgxzfcLUhPVX-4k","ozUjJ1Yu3KRjOaSgSsizhRVirATY","ozUjJ1WNDyxgWxr6-f9sujbNwc5Q","ozUjJ1Ujik9tG26xrQaJvi2sIaAw","ozUjJ1bba7-NypRnO1Hvl4WPa05o","ozUjJ1W8NOZE9G4c-VA2RBrxDj_E","ozUjJ1V6GJ0pQposYP-dEuv2BvQ8","ozUjJ1RVADYuoP2M54IewpMkPJJo","ozUjJ1WE7pytoRo6SRBRuk2i7-a8","ozUjJ1de2_iIePXrX0dn45RCMHQc","ozUjJ1aJeN9ubd-YNsNPoZ95uERQ","ozUjJ1Yo1SLYdwAm7npHZtJD-rIw","ozUjJ1Rq452ExXJhVjByzcBPap-0","ozUjJ1UsxkFnPQ2qOMGJ4vV668WI","ozUjJ1cDmV0qETrH2xWRFzDfAaeA","ozUjJ1Ye6oNqybNHVJvxEz-dBVwo","ozUjJ1bX08k3PvbAgEnSL2sLgS_Q","ozUjJ1fmedN0eRflfJ2Rw9qnGsDg","ozUjJ1fJLW7mrcTuEBJRrtmZkO_E","ozUjJ1YpvCbXMR0txvhklgGw3LH8","ozUjJ1UsKCuI5ZSZ5o4DcOPiS7SU","ozUjJ1cWTf7TUKKjdgmBGLqhi7ak","ozUjJ1f2dtzQYXyctB79EFRTBi7Q","ozUjJ1Qi8xfb7aXwvNdnhCFpz9G4","ozUjJ1aiAJb1RrrZAeiHo-npNcDU","ozUjJ1fPm53i5cxOxwXddlcgHgrw","ozUjJ1U_Hb9FaqaB4FLFVciGCa5s","ozUjJ1eBPrAZuInq81IPbXYHwlDI","ozUjJ1REymcN0b1P-qTvoHth1FyI","ozUjJ1QbaqLUyiY8OXHzi07zRatg","ozUjJ1QAo0TWfdFUSHWg4ep3KeF0","ozUjJ1bdYbwj8cYdoTb39FRZR3Is","ozUjJ1Rwocapy0uzAMxgSddDu-HU","ozUjJ1W6-jz9SFubY1KOu9JWw-Rs","ozUjJ1X3TektcVvb4gQG_2JMhaJI","ozUjJ1dp9LT_yFMJoHAYwdYxBqjQ","ozUjJ1axelxWLHnaF5q4SQpLVEb0","ozUjJ1aIQMSecZZ8NGQLrUvwyTeg","ozUjJ1S2vSB9fruM_XXdUFNuy_Hc","ozUjJ1fPWYQFGoGyVFoC1DikzOmw","ozUjJ1QjJX3iA0zr_w8z64XuLKdg","ozUjJ1aQ7SSC181hbz3mTCx_MPpY","ozUjJ1frVBLvmwi12pbRqZ0mGGGU","ozUjJ1b-KzOYmUSBSms7DVU8hWYk","ozUjJ1SVIwYMckuncC8_pNS7TJUY","ozUjJ1SzIfmoEf4-lIxrMSTdwBfc","ozUjJ1XpGoHjbTseM-nbnEZ8OJgk","ozUjJ1e3nN43hrhcZ52eDub-VAvk","ozUjJ1WoIrxxlw5h6IOSEg5W1vr0","ozUjJ1fKuJZxk4JAacb4PvO2vipI","ozUjJ1bA7--TZwJIVstcZ0wSEbX8","ozUjJ1R5vjfl6XMJwh516xhal4Kw","ozUjJ1fXrdTMGAicFJsRtSzAgLrg","ozUjJ1Vx9TO_TytPprUPj2EQDQEc","ozUjJ1aQL9kCwzeDXmVOqEnt2H_0","ozUjJ1QhZW9odMzMJxwapXsWkfkg","ozUjJ1eKEqnwYydH_oAR4uUX7-eE","ozUjJ1fsBUuJhWk8cgZQjU2VaHYI","ozUjJ1bSOKFu2azU6GZTeMPrSGiY","ozUjJ1ZETzrj7MNYnr4og3AwcOvo","ozUjJ1U4v_P67oW5pQ21rffWn-sA","ozUjJ1d4S1hsc70REN3QMKTOIkOg","ozUjJ1VIypWkcH2te104iRwAGhm8","ozUjJ1fuZlnH-tgoa2uA8Bo_I0W8","ozUjJ1YnV6uEu-g0ieJRvcWwo9CA","ozUjJ1QSsgFstjkk0a5k9MPt1ZqY","ozUjJ1XJp0ff6msrMHyNEZU0Onk4","ozUjJ1aQ6zZmphJ9PWHUiF8cvlXk","ozUjJ1c0kFP0-vqEbepHdT5P4OzQ","ozUjJ1dywgJ4F5KqT41rsxSXq5tg","ozUjJ1auLFtSTPMPJONNn7-2-ebk","ozUjJ1WTVIRI0t4Ro-eDtOkcbq1A","ozUjJ1UZHwqkHtPDXaYg8IofVpRU","ozUjJ1S7eRYtNUPl-8kF-6IYwK_I","ozUjJ1Ta8SLRHmjxG7CctCU8ld4w","ozUjJ1e0m2pF-72ypY050vVLFg1k","ozUjJ1ReTKoivovcb04Mq2sxQZyY","ozUjJ1WRKWz1bIm4J_iCOZSyFtGI","ozUjJ1VDWXhUgiC59oYn0CVqCZdM","ozUjJ1UGoP05h5-uOvX6ovc1AJnc","ozUjJ1aCM01MxfE9p5MI0wFUFwrg","ozUjJ1e1BQGO2IOPrLwmxzlUL2mw","ozUjJ1a-RvztpnFCUsXqcTBkHuJs","ozUjJ1VXyjh3-ue1PcSFs7fgt9is","ozUjJ1ReOLEM8Yivs4jHJE-BMvHE","ozUjJ1VryVd78fTJWBK7uemBdBWo","ozUjJ1cikC5ag4qlQbbS27pmW15Q","ozUjJ1aIZHXnt86AohfKHGIwf0Wo","ozUjJ1fpDBZwYnAr6dMNV8xcY7XY","ozUjJ1QTuAPvb_Vkf40quTgf73rw","ozUjJ1dpYa7rp6hXvxgngmjDr8Bs","ozUjJ1VEZ-ZGPkrSCAKd-wPN7rZU","ozUjJ1Tsi_Fcci46_eSnP90n7bqM","ozUjJ1QVc7HEnauiNOmA_3kiU-PQ","ozUjJ1ZB7gNCbMAalgysGPDxHhpg","ozUjJ1XAeWVIXwUatbStTemA-RnY","ozUjJ1RIBlTabuLzWOIv_o-l7uMA","ozUjJ1QSMaa7ZJeYIkWhTdOrQBXs","ozUjJ1dAEMjqgVZWyAYjgc07huK0","ozUjJ1ac2NkNDFdpjjaauH637tPM","ozUjJ1eRsKG6u2d03mx-4_iSbZ7c","ozUjJ1UN4MA1AfLES0-hMZxpzTgA","ozUjJ1R6wNbODxoOlTunQMg-a4Yo","ozUjJ1SOFzgUep2v5r5Wgs3y_Krk","ozUjJ1c7v65szcvu8hzphlI6-lJs","ozUjJ1aI_FqW_pXinQuaBZpNCVLY","ozUjJ1bl9YQ-IUhLGNKKejAZOgzM","ozUjJ1cqo6LysATtN69Xgw0H2eis","ozUjJ1acXutnUdCKE1zlpctyPfPw","ozUjJ1RwsAohlkXSe7PRVZSVG0qw","ozUjJ1ca3V83AwlooLS6Qgm1_ZlM","ozUjJ1Uy8eaUpw6hW9R__khRMaxk","ozUjJ1Y_qWpRT4ngdJzwV9GEk-x8","ozUjJ1VaRhk303LiPLiCZ3qMW8KY","ozUjJ1WpOYWMXhwmgKaDdmtk2T8g","ozUjJ1QRaQwPhdnJNPJvVOMrRSEI","ozUjJ1XB9zYhd7Ahz3Rk2cHTjKlM","ozUjJ1THkMbPIbah9Ssv-aMtblbU","ozUjJ1ejpv96zBQQ7A8_L-Wfnzng","ozUjJ1Vs5wLdi5wLvL1pR6xaXZqA","ozUjJ1W00TaewSXXiLp2w6LjN5xE","ozUjJ1WK4N-_H8dJnKfeErM7hUao","ozUjJ1UZS415uzlJ0m4D4NSLAJ0A","ozUjJ1VEvxVrIDEiyC6I1f07i2GY","ozUjJ1U39C8kWqoBpXaGOTV5TSiw","ozUjJ1SDKyXIl4Dqr2m3clP1RfMA","ozUjJ1YyoCTlA7aZwLMxlNg_6XLE","ozUjJ1fJQbO2s4QzAARdXCZ8Jt0U","ozUjJ1e6lOsw2P7sNnm-PNDOzZY8","ozUjJ1aqgmczLFqxyT-3m22ij4KI","ozUjJ1VK60a1spQDfyPgsjEmXIFY","ozUjJ1aMzk6Jjg-wR_3BiVWkj-OA","ozUjJ1W7HUJZiET1nHoeWuHcav80","ozUjJ1TToDuBANhLWaBo6GJuPQ4w","ozUjJ1WdgqJTK_RlqohP553Cp6as","ozUjJ1dHbTPz1YCv0N0DuaaWUT9s","ozUjJ1WqMPDZo--n4SrXjLDKFd5E","ozUjJ1QldYOtH-f2vzaxABnb2i-M","ozUjJ1b3mkoaIFO-RhWvDYI9CPqA","ozUjJ1QPqYcZcYG9EnlYskKASR6o","ozUjJ1cmLgbJRSxbUSH0oEp6WoiA","ozUjJ1ZZVd-eNESzFpeiHEMrcvFg","ozUjJ1c-fW6E4xDotK8H3W0ddQRI","ozUjJ1U4OtAi02rhtKhx8nOpKvQw","ozUjJ1f3Z-K4mhJcuWOg74rwJQb4","ozUjJ1Y8LiU36ppKd9LssLu29nuA","ozUjJ1b6l2ohaY9_eeCaeHyfGd6Q","ozUjJ1TWcPzBfCHX3gAPXWDhWGWo","ozUjJ1VO4Py6NgOYeVZCaB_REJY0","ozUjJ1QIJED8H9wejIvTgzm6RYK0","ozUjJ1VMRyGt9glbi7-BDu5A4Qxs","ozUjJ1ef_A3FEbV8YxOv_uiCMjTE","ozUjJ1YPKQPIn1Rm1IjE1SXeYDsQ","ozUjJ1U9_uhUHOC2CFN5ZzdUFA2w","ozUjJ1VFs-4UnBf7PLNcJaWtAAcI","ozUjJ1UVVPXm5ESNcuZZA96F25lc","ozUjJ1by6HtXcHaP1eV0QfJUi4Cs","ozUjJ1aMTdJriaky8fajZR0nwti0","ozUjJ1a3ma0OGPkQzxt0EzPOukA0","ozUjJ1R6dcWhBHhBGzqZmvKBWXio","ozUjJ1USa9VOKO4syFmi_Xe2bIdY","ozUjJ1bym0qWYnNIgybS5Jx75o6g","ozUjJ1XLNCpotsx_0pj4-MYzsBA4","ozUjJ1WA1xAXHtKRwLkMAaBA9frE","ozUjJ1UG-zplWwbC1JYk1buKJbJo","ozUjJ1VAKWCbaomqMYAKl5IkBwNA","ozUjJ1chCnhOuIrAZKGtgMiQq_4I","ozUjJ1f_bNaXSsw1GV9Sq2GYJhD0","ozUjJ1fQSnypqrMqabU3bISF81fk","ozUjJ1R7eUjbby0C27mK9LPtwtY0","ozUjJ1fPvmYugsHnaWCehMOgV_r8","ozUjJ1aHW5LKByysYwABO2XcRSOo","ozUjJ1TlfDFYNFHg4BtP4aT5ec6o","ozUjJ1dP8h2K7-CNGRuQbg7sSFUc","ozUjJ1X0EDpYMK17jYqYzxQqYmwE","ozUjJ1bj0sKOzJRat0UpCh-tJ-oQ","ozUjJ1arrc0eEtK-OHQlsu3O_YSg","ozUjJ1YKMrj47_BWfccxf3XBQaxs","ozUjJ1fS5nyFM51zLLR7-LhxLHR0","ozUjJ1VVOeJs_hiSQAGmi0pwtWr8","ozUjJ1e14fw7zUP3uCUJzWPEV7bo","ozUjJ1Ut9gm6Huju5l4jSP8eKDVo","ozUjJ1XqyFLNN_yaudzjDr-qvNd8","ozUjJ1YfmQHLUSIX--Rn-mDwNoIw","ozUjJ1d43jFcdX-m_I1hUbO0jR30","ozUjJ1WoXeZKs8fcJf9zP1-tlhmw","ozUjJ1af8CGOjEGqpEzRUiXWdeb4","ozUjJ1ekdh2o_lCgqhHgytORS6LY","ozUjJ1Ubrxt2gz0ekVLr1X6rq7aI","ozUjJ1WS1PjKGjkbw-8Ls9ugIGA4","ozUjJ1SyAnl-G9iUUsvW7k40XQk8","ozUjJ1bgddo449VvgQMMG1DcpgIU","ozUjJ1ebekdtAu4UdBdYImVHj0fE","ozUjJ1bZ7Bhx9tXtlQWAAM3Rihzs","ozUjJ1ZcdLMlRpcjUslf1JfkBYC4","ozUjJ1Rvb7tHlIEigm-7PnLgr4tQ","ozUjJ1V8BiMqYCHJ_N-IhaW-c9cg","ozUjJ1ZJb-PkiHXYckLPGC7YqY4g","ozUjJ1Rmjib5dPgZU127J2ube8IU","ozUjJ1To0nESEC8ADi_8KPyzUmME","ozUjJ1T1rUGMxcJDoaRQ9ETMLbEQ","ozUjJ1eZ4LGP7PnBj-fLM4aznde8","ozUjJ1b8FFygtCL6JuLzgtEPcRJA","ozUjJ1W3UadR2BQi5bMRSNJGTEYs","ozUjJ1TjTalLqiFtSFaYpSu-1dOg","ozUjJ1UF2hqq29oHsHLenUXjIGi4","ozUjJ1ZOx4nyKFdCQv-ZY10uQR9A","ozUjJ1fiHMvBt2Llb7Zih23jmcGs","ozUjJ1W4nd1TpYuIku_Cj-MYEHzo","ozUjJ1TQH7wZq-Cw4IRczMmep4ds","ozUjJ1f-3Jv3QdJJn0n4aOt--fXg","ozUjJ1TqWQV7L6MuflGo7PWSNW6s","ozUjJ1aZ0IMkKOYAUigmYPofkOUI","ozUjJ1XvDROepUT-eirkvZzvuXkE","ozUjJ1epFt7mdT_iCySZ7lBUly1c","ozUjJ1SHGpYTHlrdaSBn17rWCaz4","ozUjJ1atBc3PsbIbQXg7k14iarj8","ozUjJ1ebC2w8Aa2aLrE9dMnU4xpw","ozUjJ1WTvXHiQaIzd5yLxddToXTg"};
    /**
     *获取access_token
     * @throws IOException
     */
    public static void getAccessToken() throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
        url = url+ "&appid="+appId+"&secret="+appSecret;

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse;
        httpResponse = client.execute(httpGet);

        String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println("access_token:"+strResult);
    }

    public static void getUserList() throws  Exception{
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken+"&next_openid=";
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse;
        httpResponse = client.execute(httpGet);

        String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println("user_list:"+strResult);
    }

    public static void  getUserInfoList() throws Exception{
        String s = "[";
        for(int i = 0;i<users.length;i++){
            String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken+"&openid="+users[i]+"&lang=zh_CN";
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse;
            httpResponse = client.execute(httpGet);

            String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
            s = s+strResult+",";
        }
        s = s+"]";
        System.out.println(s);
    }

    /**
     * 获取当前菜单json
     * @return
     * @throws IOException
     */
    public static String getMenuJson() throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="+accessToken;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse;
        httpResponse = client.execute(httpGet);
        String strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        return strResult;
    }

    /**
     * 新建菜单
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static void createMenu() throws IOException {
                String menuStr =
                "{\n" +
                        "    \"button\": [" +
                        "        {" +
                        "            \"type\": \"view\"," +
                        "            \"name\": \"微信停车\"," +
                        "            \"url\": \"http://wx.zhanway.com/gtw/weixin/h5/payment\"" +
                        "        }," +
                        "        {" +
                        "            \"type\": \"view\"," +
                        "            \"name\": \"泊车\"," +
                        "            \"url\": \"http://wx.zhanway.com/gtw/weixin/h5/location\"" +
                        "        }," +
                        "        {" +
                        "            \"type\": \"view\"," +
                        "            \"name\": \"车位预览\"," +
                        "            \"url\": \"http://app.zhanway.com/themes/park/index.html" +
                        "        }" +
                        "    ]" +
                        "}";

        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ accessToken;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        System.out.println(menuStr);
        post.setEntity(new StringEntity(menuStr,"UTF-8"));
        HttpResponse response = httpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(jsonStr);
    }

    public static void main(String[] args) throws  Exception{
//           getAccessToken();
//        getUserList();
        getUserInfoList();
        //   System.out.println(getMenuJson());
//         createMenu();
    }




}
