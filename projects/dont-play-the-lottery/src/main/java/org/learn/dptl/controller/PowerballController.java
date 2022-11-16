package org.learn.dptl.controller;

import org.learn.dptl.model.PowerBallRequest;

// @RestController
public class PowerballController {

    // @RequestMapping("/")
    public void playLottery(/*@RequestBody*/ PowerBallRequest powerBallRequest) {

    }
    @RequestMapping(value = "/report/{objectId}", method = RequestMethod.GET)
    public @ResponseBody void generateReport(
            @PathVariable("objectId") Long objectId,
            HttpServletRequest request,
            HttpServletResponse response) {
    }

}
