package cn.com.jero.mynutzdeom;

import cn.com.jero.mynutzdeom.util.TextToFile;
import org.nutz.repo.Base64;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * Created by Administrator on 2016/11/29.
 */
public class DecodeTest {
    public static String code1="image=data%3Aimage%2Fpng%3Bbase64%2CiVBORw0KGgoAAAANSUhEUgAAA%2BIAAAZdCAYAAABCvulMAAAgAElEQVR4nLS953rcOrK2vY5hZtnqJhHJzlk5dFBLTpIt2V5rZk%2FY33v%2Bp1HfDxBgoVhgtzyzf9QlNXMEceOp8Nvl6QguT0dwsRrC%2BXIIF8sxXK4mcLEcw8VyDOeLEZwvRtFvbrqfdjobwGo%2BgNPFEM5XYzhbjeB0MYTVfATLWf3X%2F79o2BBm0wHMZ0NYLsawXIxhMR%2FBfOZsMR9XNoLZdAjTyQCmkwFMxn0Yj3owHvVgOhnCfDaB%2BWwCs8kIxuMhjEYDmFT%2Fj8dDmExGMJ2OYTabwHQ6DvOmk5GbNp%2FBeDqB4XgEg9EQhuMRjKdu%2Bny5gNliDpP5DEaTMQzHo2CjyTiy8XQCk9kUxrMJDMdjKIcj6I3GwfrjSbDBZArD6QyG0xmMZnMYTGbQG7l1%2BuMJjGZzGM0XMJjMoD%2BehHm90ThadzidRet664%2FGMBpPYTyZwWg8heFoEmwwmYZj8NvGv731Js4GsxkMZjMYzucwmM%2BhN5lAOR5DMRqBHQ6jZfrTafjdn83CNvrTKQyq3%2BV4zP7tTSZgh0MwgwGYwQDK8ThsD%2B8Pr9dmfr%2F9yRwGyPrjGfRGUyiHk8h6o2m1zCIsQ60%2FnoVtYOOWxetwy9L99kYz9pj8PqkNpwvoj%2BdhW9y%2B%2FbHG5xdfB7yP4XQBw%2BkiLDOaLWE0X8FgsgjHxx1vfJ7oGSLP%2F2AyDdYfj6E%2FHsFgMg7WH4%2BrZ7p%2BNgeTqXsfZvMwz0%2BbrU5htjqF0Wwe7a8%2FnpB3ZBqtS591PN2%2Fk3Sf9N3188fzRcPw%2Bt6myxXMV6cwWa5gPF%2FAZLGE6XIF0%2BUKxotl2Bferl9mslhG2%2FXzZqvTMH%2B6XEW%2F8fHU885gsjyD6eoCpqtzGC9PYTSvj2e8WMKwOg6%2FfX%2B84%2FkCJvMZzBZzWKyWsFgtYb5cwHQ%2Bc%2B3edBJsMpvCfLmA%2BXIBy9NVWG5arT9bzMM8v63lql5uPJuENtXvb1UtO1vMYTKbwmQ2jbY1X7rjo8fh9%2BuOcwaT2QKGs2V43vE9C9d%2FvoDhfO7aPNRu%2BXbMTx%2FMptCfjmE4n8J4uYLJ8sy9Ly3vZmhDJnPojWfQG8%2BgX%2F0eTBfsuv7d8sc8mCyi9fy6o%2FkKRvNVdX6LxjuODbcjuE0IVh2f3%2B5wtnTHVk33x0iPL%2BwXndtgWl3z2RJ6VXuEj4EeG11%2FOFvCcL6CfnXe5WgK5WhazyPH5q9juJ7VNcLL0etADd%2BP1PbwPcTnGN3LaplyNIViOIGCaUPpd8VfU39v8LRwjC3HNiDteOr86D3C58bdv3D90L1PfaO4Z622xYH57TZMnDu16H6Te%2BrfI3wM3Lc6eZyJ5wHvJ3WN8fWkz6%2Bf59%2B5%2Bt1bQn9SrTufw2ixCO2Q%2F%2B1tOJ%2FBYDaBwWwCo8UMRosZDOdTGM6nMFrMYLJawPR0CdPTJUxWCxgv5zBezqP%2Fx8s5jBazaN70dA6T1az6O4fRYgKD2QjGyylMT%2BcwO1vA7Mwth38vLhewul7B4nIBs%2FMZLC7msLpcwOpiAYuzGczPprD0065mwU6v53B6PYfzqzlcXs%2Fg8mYOlzdLuLpewNXNFK5upnB9O4Pb9QJu1wu4uZvD9e0Mbu7mcLdZwmZ3Ctv7M9jen8J6u4L1ZgE3t1O4vhnB9c0Ibm6nsN4sYLtbwf1%2BBfv9Cvb3c9jfz%2BHxYQmPD0t42C9hv1vA%2FW4G97sZPNzP4OPDEj4%2BrODDfg6P9zP4sJ%2FDh8dFsI8flvD5wwqeKnv%2BsIKnD0v48riAL48LeHpY1P9%2FWMLThyU8f5gH%2B%2FpxAS%2BfV%2FD6ZQWvX5bBXj4v4PXLEn4%2Bn8IfX8%2Fg5%2FMCfjzN4I%2BvC%2Fj5PIefz3P48TSDn89z%2BOPrAv78toQ%2Fvy7hz%2Bc5%2FPE0hT%2BepvC3r3P4%2B9cZ%2FP15Dn97msHfntz%2F%2F%2FN1AX9%2FXsDfnmfw928L%2BJ%2BXJfzzZQX%2F%2BLaAvz%2FP4G9PE%2Fj78xT%2B8W0O%2F%2Fg2h399ncM%2Fn2fwj6cp%2FONpAv94HsP%2FPI3g718G8PcvA%2FifpxH882s93f%2F%2B99dptO4%2Fif3reQb%2FfJrCP75M4F%2FPM%2Fj31zn8%2B3kO%2F36awb%2B%2BTOtp1fR%2FPS3gX08L%2BPfzMti%2Fnpbwzy8L%2BOeXBfzr8wL%2B9%2FMc%2Fv1pDv%2F8MIF%2FfBjDPz%2FN4P%2F7soD%2F97SE%2F%2Fe0hP%2F9vIB%2FfZzBPz9M4N%2BfZtXyM%2FjXxyn8%2B9MsMj%2Fvfz%2FPw%2F%2FOqu0%2FjuGfD5U9jqNt%2FO%2FHGfw2KLrQtx3omRMo9Qn0TQYDK6BvMujpLvR0F0rVgb7JIvPzerpbTzNu2UJ3oDRd6NkMCtMBqzpQ6CyYVV1nOgOjM9Cqi6wDUpyAkh0waL6SzozOwegMlOyCFJ1gIj%2BBPHsPefYepOiCkjloJUDJDETehSzrgBAZCJFBnnchz7sgRAZS5iBlHqaLvAtSCpBagdQKcikgE3kwoSTkUoTp3TxrGF7eWy4FdEUO7zNn77oZvOtm8D7L4SQXwTpCQkdIOBEyLPd7pwvvsxw6QkKmNHSkgpNcRNvy%2F3vD8%2FG0buas083hpJM56%2BbRceDjo8f5XqTtXZ7DuzyH37MM3gsBJ1LCeynDdPw7Woas681v9%2Fcsg792u%2FDXbreejrbjp%2FttHLQsh9%2B7At5lEt4Te9cVjWknuYKTXDWmp5Y5tOy7rgjL022%2F6wr4vZOHZfw0b35e23Hgdeh%2B%2FbR3XRnth9tXfF4qmtYRGk5yFW2HO%2Ff6HEX0fOFnkj7zJ3kGHYH%2F5tCVKszH70JXabdute2uVJAp7eZJFbbdERK6UjW2E%2B0fHSN9H99i9Bj8%2F9TCPG3CsWZKQ64NCGPDdG57fplcmzDdzxPGhnne8LLe6ukFZLqA3PQgNyVkuoCuMmEZfBx%2BnXj7rq1URgeTWoFQEoSSoS315qdjw%2FPxdvC2cimiZZXRoK0BbUxYhu6LHovfhl%2FW%2Fa9AKAMdacKzjZ%2Bt8OwoDR2loKMUnCgV2i3fjnWUCu3Ze5HBiXRt3onQ8D5XztA75vfl7URoeJfJYH6dk2oeXj9%2Bt6p3NFfRun49bH6Z37sitIHYuDYJ75Nunx4j3offj%2Ftfwe9dAX%2Ft5PDXDmp%2FcwXvMgV%2F7Qj460mWbEdC%2B4eOGx8DPq6OrO6lNGFeNJ2sk7q%2BrPn7mDB63tz14a5TOEah4X3m2tT3mQztLN7%2FidDwHj0r9BhOhA7nis%2F3Vyw%2BVtW49n5fJ0KHbwT3%2FfhvWdvxcdeYM3%2B8dJo3fG3xfaLfQG%2F0Hab3%2BNhrnLpv8fNrw%2FyusuH3idCurUHm26raZNUm5dBRIrKultDVEjKjILcaMqPCb1EYyK0OlhkVLLcaRKEgtxJEoUAWGjIjoatzyIxw00oNsqyXk6UG2ZOgBxrsyIIZGFB95X5XpnsSVClA9yTYgYZipKAYKSjHOlh%2FpGEwkjAYKxiMFQzHCkYTDaOJhMlMw3RuYDI3MJ4qGE0kjCYSxlMV5s0WFmYLC%2FOFgdlcw2wuYTaXMF8oWCwNLFcFrE4trFYGzk41nJ1qOD8zcHFu4eLcwvmZqaedKrg8M3B9UcDVuQl2fWHh6rK2m8sCbq4s3F06u70wcHth4O7SwN2lhs21hfWVgfWVgc2Vgd1NAbsbC7sbA9trDbsbA7sbA%2Fe3GvZ3BvZ3BezvCnhYW%2FiwLeFxU8LD2sDDWsGHjYYPGwOPaw0Pdwoe1%2B73x62Fj1sDnzYaPq4VfNpo%2BLxVztY62NPWwtPOwueNgU93Cr5sDDzvCvh6b%2BHrvYXnnYGnrYYvGwXPOwPPOwPfdgq%2B7RR83cpgz5scntZdeFp34XmTwbedgK87Ac%2BbDJ43Ar7tFLxsa%2Fu2kQ3z07%2BuRfj9slXwspbw7U7A60bBj52BHzsDrxsDL2sDr5sCvm9L%2BL4tq%2F8tvGwNfNtoeFlreLnT8HqrIvuxNvBjbeB7Ne%2FlRsK3a%2BHm3Rl4vTXwcqPh5UbD660J632%2F08H8tJcb6exa1Hal4PVaw7drVW%2FnWsNvwzKDvu1Aad5Dod5D32QwLAQMbB6AG4M4BnAK4mF5022AeGly6FkBPSugNLmDcpMj0O4EGPf%2FHwvi%2Fn%2BRn1S%2FM9BKgNEStBIgKwBXSoBSIoB3DeIOwrOsA3neBalEsiOIAdwDNp5Of2Prijzq9GMYoB3%2F95kIEO5BmAJLGzxTyAgdykxCp5s3QPxdN2vA%2Fe%2Bdbth%2F2BbqbHoQ9pBdd0JF9DsF4r4Ti5dpbBN1eHGnF%2B%2F%2FTRBegf3vqFNHO02Nzm%2Bik0Ut1SlrW5buB2%2FfdcwVe6wpw0BNBwg4OMdQnQLxGrr5DhYHF81OigQKvNwz6uY5APfmQRxDNwZrahx8e0j189nBrxYQ5%2BA9td82%2BKaGQdeviwGagjuFdQ7YU%2BDNDQK4ZSxkuoBMlyyI42PB%2B5W2AGktiKqN9KatCe2m%2F20KG4A5kyK0n23wzIE7hWsO3JXR7Dp4u3R%2BptMgHp4DqeoOrtaN9i4G8bxupxJtBO54U7hqayMoeKamU%2BA71CbR7XHzcftDoYyDmd%2B7wm0P%2FabtGG33uP3j9TzMc8fuAaWrLJxIA%2B8yFdrSrrLQUaZxLNy1Sp07PjZuIKDtmqUgDUNYV9swIEO3j4%2F1PV6GDDjgQYe3gngK7A%2BBOAXY1LP5lkGAtm39X4C4%2F4uvbXQdq%2BtMpzsgbm4z9d4eA%2BEciLvlDNl3AR1l4US4fpKH7q7W0NU6tEm%2BffLAjeE7ZX6ZFITXIG5AFMYBdqEhtxIyI2o4RyDuf6u%2BCvCtB%2B637iuwAwOmrytTYPrKgfjQQDE0DRAfVhA%2BCBDuzAP3eObAfDgWwWIg1zBbGlicGlieWQfepxaWKwPLlYHFUsN8oeBsZeH81AbwxnZxbuHyzMLFqYHLMxsA%2FPrCwvWlgStk15V5AL%2B9UAHAva2vHJRvry3c35awvyvgvgLxzZWC7bWE3Y2C%2FZ2Bh7WFx00BH7YFPGyMg%2FO1gv1awuNWw%2BNaweNawcOdhIc7CR82Gj5uDXzcGviw0QHCv%2BwqGF9L%2BLyW8LTVAbi%2FbDV8XssA3N%2F2Bbw8FPB1b%2BB5p%2BBpK%2BFpK%2BF5Kxsg%2Fm0n4Os2r6A7CyCOp3%2FdigjEsb3udGSNZdYSXtYSfuwM%2FLEvKhBX8LLW8Lox8H1r4fvWhv9fNx7Udfj%2F58bCn7sC%2FtgZ%2BGNbwM%2BNge%2B3OoC0B%2FSfWwvf7%2BLpHIgHGL%2BR8Hoj4futgh93OrKwbrVMAHGsiGMQx%2FDdpogPbF7Du62tNF0odBeBuITS5A7GfxnEc9DKwbhWbj6GcgziRktQleqttQStZYBxKfMIzPO8W0F73lBevDqOgZt26jCEszAuRaPjznX8k6odUsIbsE1U8hTkeDWcU8Q5JbyxHwbEsbpNLQXiGKwpiOPl485trL5jAE9tg7P3QhzsABzbOUgty3VcD3UkOBCnnZtDhtUTDMIcjDdG89G6jW1IEyke3La94emcIu6fJQ5o3bOaQ1cK6EoBHSmgI%2FKGcpyCXTqdvmfRumh7nB16H1MDARRgMchSNRn%2F9sdMp1HQp0DMKd0cyKeOiQdx%2FhgxhKuiBGWLCMSDSl3BuP9tChum4bZSKBktRwdAFdk2Xo6CNlXHveFjwuvi7ebaQlca6AgNXWkaAyShja06u1wnF%2F8O7V941zW8z9vVsjYVLaWkcutGECfSyumh9q0N1Om0NjXPQzAGmdR5vRVu6bWgIE6PoQ3E3wqpFNy4Ad3fuzJ4AHD3OILw6j30x516VvA0f70b3wEPl%2BgavBWEueeKQngEssxx029b2%2F1PDTYdu96vgngKgBvPNDo%2FCuIexvE2Dt2%2F1HbotuLt0m3X0zpKQWYMZMZAbi1kxoR2yoO5m1%2Br3ZxhGPewfRyIm6B6e%2FPw7S3AeU%2BC7EkQZR7Ucd3XoHsKdM8BuYNyBOIjA71JZWMTFPF%2BpYoPJxqp4wLGUxWp4R7Cg1pegfh86SAcg%2FhiqWGxrFXy06VxtlINGL84dxB%2BvtJwvtJweaZrVfxC13bpfmMYX18VsLm2sL0pYHtTwKaC8NsLBesA4xZ21wY2V6oyAdtrCfe3GinhFvZrDfe3Gu7vJOzXKoD4w52C%2Fa2AhzsJj2sVQPzjRsPnrYEvOwOfdxo%2BbWQDuNMgXsLLvoDnex1A%2FCnAdxPEsb3cC3i5F%2FB1mwUQ%2F7ZT8HIfQ%2Ff3e8OaB%2FJvGwfhXg3%2FY1%2FAz3sD37caXjcqwPePXRHMwzgG8R9bC3%2FuymA%2Ft7ZSv2PQ%2FrmJp1P49uZh%2B%2FutChD%2Bx8bCHxsLP9cmmuftt2GZQQ3jnSSIU9f0FKB7EPequANx55ruYZwDcQrjHsJrGK%2FNwziF8tpV3bmmY%2FPQTSGcKuTKQzmCaQ60MYS3AXg0DYF4CsJxBz8FB9S1nYMFTm0%2FqSC8AeMJEMfAFCC%2FAl6qgGM3zRQwt7m1txnu2HpFG7uqHwJ6DvCP7QC8ZVSeU69Tintbx7ZNGWrtJGeyAcApWKYQTuGZLtsN7oc85ON1eKjPG885p1pjEM%2BUhK6S0BFNl%2FM2hdnBomFBPHaxNkH1TEE1p3qnlPMU7LaZB1ppiwC5KRDHx07Ps23frJIdAbyF3JSQm16AcKyIcyDOKeIYlINVYEwhHavmjXXIPGxUXccgjqdjN3a8fUPVel0p6MZCphyM%2B8EQOvAT%2FY8UJ2yNwUimw0zhhILkIVDnlbJ2YKPQdwgWUu0fXo9uIwWteNlDgHUMUEXLJECTLnto23gbh%2FZ7nHIZq8jcN4CD%2Bq6OByySxyJ0dKz425H63nBqduo5Sz1Dh56vY7Z9rLUNIHD7eMt2OSCmynbqPaHGwfhb9suBuLesChuqj416HrhnrCN1AHBvHsRxW5UZzUI2B%2BJ0PgZybB7EncXAjWEc%2Fy97EvIih67pgihFAHFVSlCljEDc9JVTw0c2BvGhhv5AQW8oYDCSAcT7IwnDsQogjg27pU%2FnBqbzShVfGJgtVQBw557u%2Fs4XCpZzBauFjmAcu6ufrTScLRWcLRVcnNZ2eV6bB%2FKbK%2Bvc068L2FyXsLkuYXvTg811AesrA7cXGm7OJdyeywDj3ryLOlXF93fOXX13o5zb%2BlrB49bAw0ZXIC4DiGNV%2FPPOwtN9AZ93zlX900bDl60DbuqC%2FrTVYfrLQwkvDyV821v4eq%2FheaeCeRB%2F3gjkni7g61Y0XNOf1l2niN9r%2BLZTAcB%2F7G0wDsQxjL9uFHzf6uCa%2FmPnYNxD%2BM%2F7En7elwHEA4xva8X8x9o4WN4WwX5ubHBTb8B25cLO2p0OwO3%2F9xD%2B8840AX1raxAflhkMCgfhw0JGAM6p3inDrukxjGcNsyQ%2BnCrhsdXQTWEcg7h3T5cVVGMQx8CNXdWjaX45Br456GaBm8SG1%2BvJRkwrp4bjOPCkqywzLxUXHrYrNWS5DCAexYu3HE80AFBBb6QKEfdxTvE%2BBNmNeS0u7FzMOLuNNkt0iKillI5Gx0U0XS9TIE47Z7QD1TYvBfShoyyaUI1j1%2FF0rwCmlm%2BD7lQcvFcUMbRjEKdQw02LQFyKAOIUxjk45ZRgCu8Uro41GndO3evbYJhCNo3hxsfcFtfdpoZT2ObixGMl20CmDOS6AGF7B0E8fex8bLcpbKSAYzf1oleG%2BVQNx4Oc1GXdGAPWWjDGOIhWCpRyQG2MAWMMKKVAShmm43nGVEBera%2B1Bqk1SF1fS3ztk88dA%2BEYxJvtzGEwSbm6toHSIejmoKFNuaOgl1K9u8pCV8fHyUEnPqZDA4lUNT50DlThTgK%2B0EGZ5pRzLi647fr4danCnwKvNqDkYPwYgPXbpPtqG0TmFO22Y8DLtMF1Silvg%2Fe3ADPdV%2Bq5%2F5Xt0vvKPWfHbBM%2FS%2Fh4uHANeq0PwXj8TNDjd3DeUSao4XSQkHNT93HiHIB7l3QcL44VcA7EZWkjEE%2BZd1GXpYLMZhGIm0ETxHVPHgHiCgYjCaOJhmFlo6mBycywMO6B3Cvik5mC8VTCeCphMlMwmSuYLRXMV9q5qC8NLOcxjJ%2BtLJytHJRj86r4%2BUrWMH6mg2EQv72ysL4qQrw4jhm%2FOddwd2Fgc1lUAF5E8eI1kNdx47sbFUDcq%2BUO1L27urPHjYaPWwufdgV82ln4srPweVuDuFfJv%2Bxq%2BKb29d7Ct31RWQXjSB1%2F3ogQ%2F%2F0V%2FQ4qeYgRz%2BDbTsLr3gRFnANx6qJOXdU9jNNYcayKO%2Bg2lVru3NqDen4n4MdGwc%2Btdi7qOwM%2Ftxp%2BbjX8qOa%2F3snDEF6B%2Bw%2BkfDfc0it3dA%2Fif24L%2BK1vOzAouhWM5zAqJQwLyQI3nRa5o%2BtuSNaGAbx2Uc8jCC9NHpK1UbMmB0vUcs4lPYZz6p7eVMQpiHtVPJomspCs7WiXcwTd3DS%2FjUwejkflEkphowCBk7rRmPEGJKgaxLuZiKD8ENiH3ygekut4cnHeeNljQRkr3zhxG40Lp%2FGZhywc4xGKN9eBSYL4ER3NNhDnFPFjlHk6rc3VvE0tZxPjtMC4T9LmE7V5d3cP4pxrOufxgVVqzjUdgzgF65QrOE1eRhOgddC79StAznmsHHJN52AWq9n0mDnFu929%2FDgQF8YiELeQawvClAjEy0qFaQ4U0O36Y84TcdjK6EgRxyDujSrgXDI3CuIeoL1h4OZ%2BU8NQ7qBdgVSc90B9jo1whwNKuGuvmqDEQQ%2FXAacg3tY%2BHQvih2DxEEhxMH8s5BwDR4dAlTuGJqik2%2FBUTHsK9Ln5%2BBhwO87dAzoYcQiC265%2FCri568IOokhz1DHQ63LMc%2FHfBHHufA5t863P2688n23bCiCum7HiKRBPPWvccxc%2FT5rcqzphW1drNomkd0nvVPNwMkkuVhwD%2BrEg7hK6qSg2nFPGcax4ZiR0TQ6iFFWMeAzipq8DiNtBHSPemxgoRxp6QxVAvD%2FSMByZoIqPpgbGMwujqalixk1I5EYTt3kQx39nCwOLZRUvvtSwmElYzhWCcGenSwOrhYbVUqJkbgbOzxScnxF1vALxaxwrfm7g9kzDzamC6zMFN%2Be6St5mK7f12HU9AvErDetLCetLCZsrFZK4YWU8JHVbOwgPbutrp4p%2FqiDcg7j%2F%2F%2FPWuap%2F2agGjFN1nIL4FwTdL%2Fc6qN21u7pqgLhf7nVvGkZV8La48e9bDT%2FvbYgVp2p57bYew%2Fv3tQwgjgHcTwvzNjYo5Ydg3Cdq8zBOFfHvtyqo5b%2F1zAn0bScCcQfj4iCMOxAXAcBDlnXkkt6zGfSL2CXdu6gXFXBTK6wAY2K1nFPErRGsMp4CcZwxncuaXoN4E6o5N%2FUoEVtL5nTsmk4hN%2BWazsE6VRU7UoWkbhgsMJxT93UP31kuayjPm8mraLK44KZO4rY55RtPCyOy1YeAVY0Yd%2FZ3eQ5%2F7XbhL51OBOJc4jasyv%2BqIs7BMAVirgOc6hi3dRTe5%2B3uiqlph1z0TgRyM5dxTDeO3aZZXtuSt%2BHEbxiyKYi3Ke80RpwORrUla6OKeAq2qRs2je%2FFy3SVDu8IHRhIKe4UujnF3W%2BTHmcKxKWJ47BT8O7PxbtMp1R%2FDpYjYNZxnLqzAqTtRSDu3NSLg7Hn%2FtqIRIy2B%2B8A30j19rHbprBgyyKKIediw8N2KnhWStU";

    public static void main(String[] args) {
        Base64 base64=new Base64();



        String resultBase=getFromBASE64(code1);
        TextToFile textToFile=new TextToFile();
        textToFile.setTextToFile("D:\\temp1.txt",resultBase);
    }


    // 将 BASE64 编码的字符串 s 进行解码
    public static String getFromBASE64(String s) {
        if (s == null) return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    //将 BASE64 编码的字符串 InputStream 进行解码
    public static java.nio.ByteBuffer getFromBASE64byte(String s) {
        if (s == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBufferToByteBuffer(s);//decoder.decodeBuffer(s);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public  static String  readTxtFile(String filePath){
        StringBuffer stringBuffer=new StringBuffer();
        try {

            String encoding="UTF-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                  stringBuffer.append(lineTxt);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
