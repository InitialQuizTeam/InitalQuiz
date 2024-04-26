package src;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AccountManager {
    /**
     * @problem => 절대 경로일 경우, Mac /Windows 간 호환문제 있음
     * @Solution => 상대 경로 처리
     */
     //절대 경로
    //    public static final String ROOT_PATH = "/Users/kon/konFolder/src/TestZone";

    //프로그램 실행된 폴더 디렉토리 위치를 읽어옴
    // (프로젝트 실행되는 폴더 위치 읽어옴) = 상대 경로
    static Path currentPath = Paths.get("");
    static String path = currentPath.toAbsolutePath().toString();
    //        System.out.println("현재 작업 경로: " + path);

    //    public static final String ROOT_PATH = "/Users/kon/konFolder/src/TestZone";
    public static final String ROOT_PATH = path;
    String targetPath = ROOT_PATH + "/CommonTextFile/memberList.txt";


    static Scanner sc = new Scanner(System.in);
    //일단 Write 하고
    // 추후에는 미리 읽어와서 검사하는 것 만들기

    //계정 생성 프로세스
    static void CreateAccountProcess() {

        //폴더 체크
        //파일 정보 객체 생성
        File directory = new File(ROOT_PATH + "/CommonTextFile");
        //폴더 없으면 생성
        if (!directory.exists()) directory.mkdir();

        //파일 생성하기
        File newfile = new File(ROOT_PATH + "/CommonTextFile/memberList.txt");

        if (!newfile.exists()) {
            try {
                newfile.createNewFile();
            } catch (IOException e) {
                System.out.println("파일 생성에 실패했습니다.");
            }
        }

        String gameId = null;   //게임 아이디
        String userName = null; //사람 이름
        String passWord = null; //비밀번호

        //사용은 안하는 변수들
        int score = -1;       //점수
        int gameLife; //게임 목숨
        int hint;     //힌트 갯수
        //<-----------------------------

        try (FileWriter fw = new FileWriter(newfile, true)) {
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");

            for (; ; ) {
                System.out.print("☁︎     사용할 아이디를 입력하세요: ");
                gameId = sc.nextLine();
                if (gameId.equals("") || gameId == null) System.out.println("☁︎     아이디를 다시 입력하세요.");
                else break;
            }
            for (; ; ) {
                System.out.print("☁︎     이름을 입력하세요: ");
                userName = sc.nextLine();
                if (userName.equals("") || userName == null) System.out.println("☁︎     이름을 다시 입력하세요.");
                else break;
            }
            for (; ; ) {
                System.out.print("☁︎     사용할 비밀번호를 입력하세요: ");
                passWord = sc.nextLine();
                if (passWord.equals("") || passWord == null) System.out.println("☁︎     비밀번호를 다시 입력하세요.");
                else break;
            }
            System.out.println("☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎☁︎");
            //아이디,이름,비밀번호,정답갯수(0),목숨(5),힌트(5)
            String outputMessage = String.format("%s,%s,%s,0,5,5\n", gameId, userName, passWord);

            //파일로 저장
            fw.write(outputMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("\n\n☁︎     %s님 반값습니다.😁\n☁︎     당신은 이제 회원입니다!\n", userName);
    }
}
