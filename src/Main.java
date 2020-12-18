import com.exceptions.*;
import com.flashlight.*;
import com.interfaces.ForCave;
import com.korotyshka.*;
import com.korotyshka.certainKorotyshka.*;
import com.place.grotto.*;
import com.place.tunnel.*;
import com.place.wall.*;
import com.researches.Researches;
import com.road.*;
import com.shoes.*;
import com.weather.*;

import java.lang.Math;

public class Main{
    public static void main(String[] args) throws NameCheck {
        Korotyshka.BodyPart hands = new Korotyshka.BodyPart("Руки");
        Korotyshka.BodyPart legs = new Korotyshka.BodyPart("Ноги");
        Korotyshka.BodyPart head = new Korotyshka.BodyPart("Голова");
        Korotyshka.BodyPart body = new Korotyshka.BodyPart("Туловище");
        Korotyshka.Eyes eyes = new Korotyshka.Eyes();
        Ponchik ponchik = new Ponchik(Location.CAVE_ENTRANCE, Status.UNKNOWN, Status.UNKNOWN,
                "Пончик", ConditionKorotyshka.UNDESIRABLY, StatusNature.FLIMSY);
        Neznaika neznaika = new Neznaika(Location.CAVE_ENTRANCE, Status.UNKNOWN , Status.UNKNOWN,
                "Незнайка", ConditionKorotyshka.WITH_PLEASURE,StatusNature.ACTIVE);
        Weather weather = new Weather(WeatherNow.FRESH, WeatherStatusNow.PlEASANT);
        Researches researches = new Researches();
        researches.setName("исследования");
        Tunnel.Darkness darkness = new Tunnel.Darkness();
        Boots boots = new Boots();
        Flashlight flashlight = new Flashlight();
        Tunnel.Bottom bottom = new Tunnel.Bottom();
        bottom.setName("Дно тунеля");
        Road road = new Road(StatusRoad.UNKNOWN, StatusRoad.UNKNOWN);
        Tunnel.Wall leftWall = new Tunnel.Wall(ConditionWall.SUDDENLY , StatusWall.LEFT);
        Tunnel.Wall rightWall = new Tunnel.Wall(ConditionWall.SUDDENLY , StatusWall.RIGHT);
        Grotto grotto = new Grotto(StatusGrotto.NONE, StatusGrotto.NONE, StatusGrotto.NONE);


        class Time{
            int time;
            String dimension;

            Time(int time, String dimension) {
                this.time = time;
                this.dimension = dimension;
            }

            int randomTimePass(){
                this.time = (int)(Math.random() * (60.0 - 5.0) + 1.0);
                return this.time;
            }

            int timePass(int timePass){
                this.time += timePass;
                return this.time;
            }

            String changeTimeDimension(String dimension){
                this.dimension = dimension;
                return this.dimension;
            }
        }
        ponchik.changeLocation(Location.CAVE);
        neznaika.changeLocation(Location.CAVE);

        Time time = new Time(0,"секунд");

        ponchik.changeConditionKorotyshka(ConditionKorotyshka.FIXED);
        ponchik.sit();
        neznaika.folowExample(ponchik);
        neznaika.sitBeside(ponchik);
        neznaika.changeConditionKorotyshka(ConditionKorotyshka.FIXED);
        neznaika.sit();
        time.randomTimePass();

            try {
                if (neznaika.getStatusNature().equals(null)) {
                    throw new StatusCheck("Поле натура не может быть пустой строкой !!!");
                }
                if (neznaika.getStatusNature().equals("деятельная") || neznaika.getStatusNature().equals("сильная")) {
                    System.out.println("Прошло " + String.valueOf(time.time) + " " + time.dimension);
                }
                else{
                    time.changeTimeDimension("минут");
                    System.out.println("Прошло " + String.valueOf(time.time) + " " + time.dimension);
                }
            }
            catch (StatusCheck statusCheck){
                System.out.println(statusCheck.getMessage());
            }
            finally {
                neznaika.getUp();
            }
        neznaika.changeConditionKorotyshka(ConditionKorotyshka.CAREFULLY);
        System.out.println(eyes.accustomed(neznaika) + darkness.getName());
        eyes.see(neznaika);

        ForCave cave = new ForCave() {
            String name = "пещера";
            @Override
            public void notEnd(String where) {
                System.out.println(name + " не кончается " + where) ;
            }

            @Override
            public void lead(String where) {
                System.out.println(name + " ведет " + where);
            }
        };
        cave.notEnd("поблизости");
        cave.lead("вглубь горы");
        neznaika.speech(ponchik,researches);


        ponchik.changeStatus(Status.UNWILLINGNESS);
        neznaika.changeStatus(Status.INTEREST);
        neznaika.changeStatusSecond(Status.UNCOLDLY);

        ponchik.getUp();
        ponchik.groan();
        ponchik.putOn(boots);
        ponchik.goesFor(neznaika);


        for (int step = 1; step < (int) (Math.random() * (9.0 - 2.0) + 2.0); step++){
            System.out.println("шаг " + step);
        }

        ponchik.changeLocation(Location.TUNNEL);
        neznaika.changeLocation(Location.TUNNEL);

        System.out.println(ponchik.getName() + " и " + neznaika.getName() + " не успели сделать 10 шагов");
        System.out.println(ponchik.getName() + " и " + neznaika.getName() + " очутились в " + darkness.Absolute());
        ponchik.speech(darkness, researches);

        ponchik.want("повернуть назад");

        neznaika.getFlashlight(flashlight);
        flashlight.changeFlashlightStatusNow(FlashlightStatusNow.ON);
        System.out.println(darkness.Dissipated(flashlight));

        ponchik.changeStatus(Status.ANNOYANCE);
        ponchik.grunt();

        ponchik.changeStatus(Status.FATIGUE);
        ponchik.changeStatusSecond(Status.COLDLY);

        ponchik.changeConditionKorotyshka(ConditionKorotyshka.UNDESIRABLY);

        ponchik.goes(2,neznaika);

        weather.changeWeatherInfluence(WeatherInfluence.FAVOURABLY);
        weather.WeatherActionFor(ponchik);
        weather.changeWeatherNow(WeatherNow.FROST);
        weather.changeWeatherStatusNow(WeatherStatusNow.TERRIBLE);
        weather.changeWeatherInfluence(WeatherInfluence.FAVOURABLY);
        weather.changeWeatherInfluence(WeatherInfluence.DISGUSTING);
        weather.WeatherActionFor(ponchik);


        if (weather.getWeatherNow().equals("холод") &&
                ( ( ponchik.getStatus().equals("холодно")
                        && ponchik.getStatusSecond().equals("холод") )
                ||
                ( ponchik.getStatus().equals("усталость")
                        && ponchik.getStatusSecond().equals("холод") ) ) ){

            hands.freezes(ponchik);
            legs.freezes(ponchik);

            ponchik.TryToWarm(hands);
            ponchik.TryToWarm(legs);
            if (weather.getWeatherNow().equals("холод") && weather.getWeatherStatusNow().equals("жуткий(ая)")){
                System.out.println("Персонажу " + ponchik.getName() + " не удалось согреться");
            }
            else{
                System.out.println("Персонажу " + ponchik.getName() + " удалось согреться. " + ponchik.getName() + " кайфуууует)0)");
            }

        }
        else{
            System.out.println(ponchik.getName() + " наслаждается погодой:" + weather.getWeatherStatusNow() +
                    " " + weather.getWeatherNow());
        }

        if (weather.getWeatherNow().equals("холод") &&
                ( (neznaika.getStatus().equals("не холодно")
                        && neznaika.getStatusSecond().equals("интерес") )
                ||
                (neznaika.getStatus().equals("интерес")
                        && neznaika.getStatusSecond().equals("не холодно")) ) ){

            weather.changeWeatherInfluence(WeatherInfluence.WHATEVER);
            weather.WeatherActionFor(neznaika);

        }

        else{
                hands.freezes(neznaika);
                legs.freezes(neznaika);

                neznaika.TryToWarm(hands);
                neznaika.TryToWarm(legs);
                if (weather.getWeatherNow().equals("холод") && weather.getWeatherStatusNow().equals("жуткий(ая)")){
                    System.out.println("Персонажу " + neznaika.getName() + " не удалось согреться");
                }
                else{
                    System.out.println("Персонажу " + neznaika.getName() + " удалось согреться. " + neznaika.getName() + " кайфуууует)0)");
                }
        }

        neznaika.changeStatus(Status.CHEERFULLY);
        neznaika.goAhead();
        neznaika.changeConditionKorotyshka(ConditionKorotyshka.CAREFULLY);
        eyes.see(neznaika);

        road.changeStatusRoadFirst(StatusRoad.WIDE);
        road.changeStatusRoadSecond(StatusRoad.ENLIGHTENED);

        road.goOnTheRoad(neznaika);
        road.goOnTheRoad(ponchik);

        int steps = (int) (Math.random() * (10.0 - 2.0) + 2.0);
        ponchik.changeConditionKorotyshka(ConditionKorotyshka.EASY);
        neznaika.changeConditionKorotyshka(ConditionKorotyshka.EASY);

        for (int step = 1; step <= steps; step++){
            System.out.println("шаг " + step + " ");
            bottom.Falls();
            ponchik.goAhead();
            neznaika.goAhead();
            if (!neznaika.getStatus().equals("неувереность (персонажу кажется)")
            || !ponchik.getStatus().equals("неувереность (персонажу кажется)")) {
                neznaika.changeStatus(Status.SEEMS);
                ponchik.changeStatus(Status.SEEMS);
            }
            System.out.println(ponchik.getName() + " испытывает состояние " + ponchik.getStatus() + ", что " +
                    ponchik.someonePushKorotyshka("кто-то"));
            System.out.println(neznaika.getName() + " испытывает состояние " + neznaika.getStatus() + ", что " +
                    neznaika.someonePushKorotyshka("кто-то"));
        }

        rightWall.goRight();
        leftWall.goLeft();

        ponchik.changeStatus(Status.INTEREST);
        neznaika.changeStatus(Status.INTEREST);
        ponchik.goAhead();
        neznaika.goAhead();

        ponchik.changeLocation(Location.GROTTO);
        neznaika.changeLocation(Location.GROTTO);

        grotto.changeStatusGrottoFirst(StatusGrotto.HUGE);
        grotto.changeStatusGrottoSecond(StatusGrotto.UNDERGROUND);
        grotto.changeStatusGrottoThird(StatusGrotto.SUBLUNARY);

    }
}