public class MessangeToInsects {
    public String tone;
    public String msg;
    public Insects toWhom;
    public Personage fromWhom;
    class AngryInsectException extends Exception{
        AngryInsectException(String msg){
            super(msg);
        }
    }

    /**
     * Метод, который создает сообщение
     */
    MessangeToInsects(String msg, String tone, Insects toWhom, Personage fromWhom){
        this.msg = msg;
        this.toWhom = toWhom;
        this.fromWhom = fromWhom;
        this.tone = tone;
    }
    /**
     * Метод в котором персонаж ругается на насекомого.
     * Причем, если skillSwear у насекомого больше, чем у персонажа, то он отвечает.
     */
    void sayMassange(){
        System.out.println("\"" + msg + "\"" + " - " + tone + " " + fromWhom.name + ".");

        if (toWhom.skillSwear >= fromWhom.skillSwear){

            class Answer {
                private String ans[] = {"Cам такой!", "Не кричи на меня!", "Ой все!", "Бла-бла-бла", "Мяу"};
                private String tone[] = {"выругася", "крикнул", "обиделся", "проворчал", "чертыхнулся"};

                private Answer(String... ans){
                    this.ans = ans;
                }

                private void sayAnswer() throws AngryInsectException {
                    if (ans.length == 0 || tone.length == 0){
                        throw new AngryInsectException(toWhom + " топнул ногой, потому что не нашел, что ответить.");
                    }
                    System.out.println("\"" + ans[(int)(Math.random()*100 % ans.length)] + "\"" + " - " + tone[(int)(Math.random()*100 % tone.length)] + " " + toWhom + ".");
                }
            }

            Answer answer = new Answer();

            try {
                answer.sayAnswer();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(toWhom + " заплакал и промолчал, потому что обратился к недопустимому индексу массива.");
            } catch (AngryInsectException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Никто ничего не ответил, потому что, на самом деле, никакого клопа не существует. Как и персонажа.");
            } catch (Exception e){
                System.out.println(toWhom + " просто испарился. Никто не знает почему.");
            }
        }
    }
}

